package de.htwg.se.VierGewinnt.model

import de.htwg.se.VierGewinnt.util.EnemyStrategy
import scala.util.Random

case class EnemyComputerStrategy() extends EnemyStrategy {
  override def insertChip(pg:Playground, col: Int): Playground = {
    if (pg.getPosition(col) != -1)
      val temp = pg.copy(pg.grid.replaceCell(pg.getPosition(col), col, Cell(pg.player(0).chip)), pg.player.reverse, pg.enemStrat)
      temp.grid.checkFull() match {
        case false if (temp.grid.checkWin() == 0) => ComputerinsertChip(temp)
        case _ => temp
      }

    else
      pg.error = "This column is full try another one"
      pg
  }

  def ComputerinsertChip(pg:Playground): Playground = {
    var chosenCol = Random.between(0,pg.size)

    for (i <- 1 to pg.size)
      if (pg.getPosition(chosenCol) != -1) {
        chosenCol = Random.between(0,pg.size)
      }
    pg.copy(pg.grid.replaceCell(pg.getPosition(chosenCol), chosenCol, Cell(pg.player(0).chip)), pg.player.reverse, pg.enemStrat)
  }
}