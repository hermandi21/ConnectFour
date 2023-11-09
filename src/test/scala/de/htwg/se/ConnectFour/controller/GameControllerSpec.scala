package de.htwg.se.ConnectFour.controller


import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.util._
import de.htwg.se.ConnectFour.view._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


import java.io.ByteArrayInputStream

class GameControllerSpec extends AnyWordSpec with Matchers {
  "The GameController" should {
    val controller = new GameController(new Tui)
    val initialField = GameLogic.getInitialMatchField
    val automaticField = new AutomaticMatchfield(initialField)
    val player1 = RealPlayer("Max Mustermann")
    val player2 = RealPlayer("Erika Mustermann", 'o')

    "return a initial matchfield, a real players and an AI player if game mode 1 was selected (including two invalid inputs)" in {
      val stdinString ="""
                         |1
                         |Pascal""".stripMargin
      val stdin = new ByteArrayInputStream(stdinString.getBytes)
      Console.withIn(stdin) {
        val result = controller.startGame()
        result._1 shouldBe a [RealPlayer]
        result._3 shouldBe a [MatchfieldModel[_]]
      }
    }

    "return a initial matchfield, and two real players if game mode 2 was selected (including two invalid inputs)" in {
      val stdinString ="""wrongInput
                         |3
                         |2
                         |Pascal
                         |Andreas""".stripMargin
      val stdin = new ByteArrayInputStream(stdinString.getBytes)
      Console.withIn(stdin) {
        val result = controller.startGame()
        result._1 shouldBe a [RealPlayer]
        result._2 shouldBe a [RealPlayer]
        result._3 shouldBe a [MatchfieldModel[_]]
      }
    }
  }
}
