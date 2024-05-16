package de.htwg.se.VierGewinnt.model

import de.htwg.se.VierGewinnt.util.EnemyStrategy

import scala.util.{Try, Random}

case class EnemyPersonStrategy() extends EnemyStrategy {
  override def insertChip(pg: Playground, col: Int): Playground = {
    if (pg.getPosition(col) != -1) {
      val updatedPgTry: Try[Playground] = for {
        grid <- pg.grid.replaceCell(pg.getPosition(col), col, Cell(pg.player(0).chip))
      } yield pg.copy(grid = grid, player = pg.player.reverse, enemStrat = pg.enemStrat)

      updatedPgTry.getOrElse {
        // Handle failure here, for example:
        pg.error = "An error occurred while updating the playground"
        pg
      }
    } else {
      pg.error = "This column is full, try another one"
      pg
    }
  }
}
