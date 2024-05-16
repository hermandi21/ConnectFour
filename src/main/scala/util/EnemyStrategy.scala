package util

import de.htwg.se.VierGewinnt.model.Playground

/**
  * Strategy Pattern which decide if you want to play against a
  * computer or a actually real person
  */


trait EnemyStrategy {
  def insertChip(test: Playground, col: Int): Playground
}
