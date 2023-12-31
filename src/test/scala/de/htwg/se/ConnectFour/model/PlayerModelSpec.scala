package de.htwg.se.ConnectFour.model

import org.scalatest._
import matchers._
import org.scalatest.wordspec.AnyWordSpec

class PlayerModelSpec extends AnyWordSpec with should.Matchers {
  "A PlayerModel" should {
    val player = RealPlayer("Max Mustermann", 'Y')
    "have a name" in {
      player.name should be ("Max Mustermann")
    }
    "have a symbol resembled by one character" in {
      player.sign
    }
    "have a string representation that equals its symbol" in {
      player.toString() should be(player.sign.toString)
    }
  }
}
