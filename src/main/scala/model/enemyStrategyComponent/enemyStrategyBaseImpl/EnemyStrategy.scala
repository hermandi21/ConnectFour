package de.htwg.se.VierGewinnt


import de.htwg.se.VierGewinnt.model.PlaygroundTemplate

/**
  * Strategy Pattern which decide if you want to play against a
  * computer or a actually real person
  */


trait EnemyStrategy {
  def insertChip(playground: PlaygroundTemplate, col: Int): PlaygroundTemplate
}
