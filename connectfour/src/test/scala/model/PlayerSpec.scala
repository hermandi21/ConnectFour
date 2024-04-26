package de.htwg.se.VierGewinnt.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.* 
import scala.io.AnsiColor.* 

class PlayerSpec extends AnyWordSpec {
  "A Player" when {
    "new" should {
      val player = Player("player 1", Chip.RED)
      "have a name " in {
        player.name should be("player 1")
      }
      "have a string representation" in {
        player.toString should be("player 1")
      }
      "have a red background color" in {
        player.chip.getColorCode should be(s"${RED_B}")
      }
    }
  }
}