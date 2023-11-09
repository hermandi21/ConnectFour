package de.htwg.se.ConnectFour

import org.scalatest._
import org.scalatest.matchers.should.Matchers
import de.htwg.se.ConnectFour.view.Tui
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.wordspec.AnyWordSpec

import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.util._
import java.io.ByteArrayInputStream

class MainSpec extends AnyWordSpec with Matchers {
  "The Connect4 programm" should {
    val player1 = RealPlayer("Max")
    val player2 = RealPlayer("Tom", 'o')
    val matchfield = GameLogic.getInitialMatchField
    val view = new Tui()
    val controller = new GameController(view)

    "End if a player has won" in {
      val stdinString =
        """1
          |2
          |1
          |2
          |1
          |2
          |1
          |""".stripMargin

      val stdin = new ByteArrayInputStream(stdinString.getBytes)
      Console.withIn(stdin) {
        ConnectFour.playRound(view, controller, matchfield, player1, player2, player1) should be (true)
      }
    }
  }
}