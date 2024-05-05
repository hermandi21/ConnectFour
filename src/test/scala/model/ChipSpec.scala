package de.htwg.se.VierGewinnt.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import scala.io.AnsiColor._

class ChipSpec extends AnyWordSpec {
  "Create chip for empty Cell" when {
    val chip = Chip.EMPTY
    "have value 0" in {
        chip.getValue should be(0)
    }
    "have color blue" in {
        chip.getColorCode should be(BLUE_B)
    }
  }
  "Create Chip for red Cell" when {
    val redChip = Chip.RED
    "have value 1" in {
        redChip.getValue should be(1)
    }
    "have color red" in {
        redChip.getColorCode should be(RED_B)
    }
  }
  "Create Chip for yellow Cell" when {
    val yellowChip = Chip.YELLOW
    "have value 2" in {
        yellowChip.getValue should be(2)
    }
    "have color yellow" in {
        yellowChip.getColorCode should be(YELLOW_B)
    }
  }
}