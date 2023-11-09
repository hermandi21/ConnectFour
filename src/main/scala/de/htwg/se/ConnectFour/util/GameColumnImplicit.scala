package de.htwg.se.ConnectFour.util

import de.htwg.se.ConnectFour.model._

object GameColumnImplicit {
  // Implizite Konvertierung von Int zu GameColumn
  implicit def convertIntToGameColumn(column: Int): GameColumn = new GameColumn(column)

  // Implizite Klasse, die einen Int (Spaltenindex) umhüllt
  implicit class GameColumn(column: Int) {
    // Methode zum Zuweisen eines Spielers zu einer Spalte (über den -> Operator)
    def ->(player: PlayerModel): GameColumnPlayerMapping = {
      GameColumnPlayerMapping(column, player)
    }
  }
}

