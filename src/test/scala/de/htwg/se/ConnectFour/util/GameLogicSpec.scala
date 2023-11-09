package de.htwg.se.ConnectFour.util

import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.util._

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scala.util.{Failure, Success}

class GameLogicSpec extends AnyWordSpec with Matchers {
  "The GameLogic" should {
    val initialField = GameLogic.getInitialMatchField
    val automaticField = new AutomaticMatchfield(initialField)
    val emptyMatchfield = GameLogic.getInitialMatchField

    val player1 = RealPlayer("Max Mustermann")
    val player2 = RealPlayer("Erika Mustermann", 'o')
    val player3 = RealPlayer("Hans Peter", 'o')
    val noPlayerPlayer = RealPlayer("NoPlayer", '-')
    val initialRoundModel = RoundModel(0, initialField, player1)


    "return an initial match field" in {
      GameLogic.getInitialMatchField.toString should be ("+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "| - | - | - | - | - | - | - |\n" +
                                                         "+---+---+---+---+---+---+---+\n" +
                                                         "  1   2   3   4   5   6   7")
    }

    "return an Some(MatchfieldModel(...)) with one token" in {
      GameLogic.setChip(initialRoundModel).get.matchfield.toString should be ("+---+---+---+---+---+---+---+\n" +
                                                                              "| - | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "| - | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "| - | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "| - | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "| - | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "| x | - | - | - | - | - | - |\n" +
                                                                              "+---+---+---+---+---+---+---+\n" +
                                                                              "  1   2   3   4   5   6   7")
    }

    "should fail if the column where the token should be placed is outside of the range 0 to 5" in {
      an [Exception] should be thrownBy GameLogic.getNextEmptyRow(10, initialField)
    }

    "return with an empty list the value false" in {
      GameLogic.checkIfSomeoneWon(initialField, player1) should be (false)
    }

    "return a failure if a invalid column to insert the chip was selected" in {
      an [Exception] should be thrownBy GameLogic.setChip(RoundModel(42, initialField, player1)).get
    }

    "return false if the symbol list is empty" in {
      val list : List[Boolean] = List()
      GameLogic.numberOfSuccessivelySymbols(list,0,0) should be (0)
    }

    "return a Failure if the input for checkIfGameIsOver already was a failure" in {
      an [Exception] should be thrownBy GameLogic.checkIfGameIsOver(Failure(new Exception("Not relevant"))).get
    }

  }
}
