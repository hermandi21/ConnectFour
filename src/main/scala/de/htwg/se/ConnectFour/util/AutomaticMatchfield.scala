package de.htwg.se.ConnectFour.util

import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.util._
import de.htwg.se.ConnectFour.view._
import scala.annotation.tailrec
import scala.language.implicitConversions
import de.htwg.se.ConnectFour.util.GameColumnImplicit.GameColumn

class AutomaticMatchfield(matchfield: MatchfieldModel[PlayerModel]) {
  def play(gameColumns: GameColumnPlayerMapping*): MatchfieldModel[PlayerModel] = {

    @tailrec
    def setChips(matchfield: MatchfieldModel[PlayerModel], gameColumns: Seq[GameColumnPlayerMapping]):MatchfieldModel[PlayerModel] = {
      if (gameColumns.isEmpty)
        matchfield
      else {
        val gameColumn = gameColumns.head
        val resultMatchfield = GameLogic.setChip(RoundModel(gameColumn.column, matchfield, gameColumn.player))
        setChips(resultMatchfield.get.matchfield, gameColumns.tail)
      }
    }

    setChips(matchfield, gameColumns)
  }
  implicit def convertIntToGameColumn(column: Int): GameColumn = new GameColumn(column)

  
}

