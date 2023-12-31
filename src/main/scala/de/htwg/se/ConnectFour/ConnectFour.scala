package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.controller._
import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.view._
import de.htwg.se.ConnectFour.util


import scala.annotation.tailrec

object ConnectFour {
  def main(args: Array[String]): Unit = {
    val view = new Tui()
    val controller = new GameController(view)
    val models = controller.startGame()
    val player1 = models._1
    val player2 = models._2
    val startField = models._3

    val startPlayer = if (scala.util.Random.nextInt(2) == 0) player1 else player2


    playRound(view, controller, startField, player1, player2, startPlayer)
  }

  @tailrec
  def playRound(view:Tui, controller:GameController, matchfield:MatchfieldModel[PlayerModel], player1:PlayerModel, player2:PlayerModel, currentPlayer:PlayerModel):Boolean = {
    controller.playRound(matchfield, player1, player2, currentPlayer) match {
      case Left(roundSuccessful) =>
        val nextPlayer = roundSuccessful._1
        val newMatchfield = roundSuccessful._2
        playRound(view, controller, newMatchfield, player1, player2, nextPlayer)
      case Right(GameOverFlag) => true // Game Over
    }
  }
}
  
