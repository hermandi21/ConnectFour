package de.htwg.se.VierGewinnt.model

import de.htwg.se.VierGewinnt.util.EnemyStrategy
import scala.util.Random

case class EnemyComputerStrategy() extends EnemyStrategy {
  override def insertChip(pg: Playground, col: Int): Playground = {
    if (pg.getPosition(col) != -1) {
      val temp = pg.copy(grid = pg.grid.replaceCell(pg.getPosition(col), col, Cell(pg.player(0).chip)), player = pg.player.reverse, enemStrat = pg.enemStrat)
      if (!temp.grid.checkFull() && temp.grid.checkWin() == 0)
        ComputerinsertChip(temp)
      else
        temp
    } else {
      pg.copy(error = "This column is full. Try another one.")
    }
  }

  private def ComputerinsertChip(pg: Playground): Playground = {
    var chosenCol = Random.between(0, pg.size)

    while (pg.getPosition(chosenCol) != -1) {
      chosenCol = Random.between(0, pg.size)
    }

    pg.copy(grid = pg.grid.replaceCell(pg.getPosition(chosenCol), chosenCol, Cell(pg.player(0).chip)), player = pg.player.reverse, enemStrat = pg.enemStrat)
  }
}
