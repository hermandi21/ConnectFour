package de.htwg.se.VierGewinnt.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import scala.io.AnsiColor.{BLUE_B, RED_B, YELLOW_B}
import java.time.Year

class CellSpec extends AnyWordSpec{
  " A Cell" when {
    "Empty" should {
        "be displayed as a blue Cell" in {
          Cell(Chip.EMPTY).toString() should be(s"${BLUE_B}" + s"   ")
        }
    }
    "picked by Player 1" should {
      "be displayed as a yellow cell" in {
        Cell(Chip.YELLOW).toString() should be(s"${YELLOW_B}" + s"   ")
      }
    }
    "picked by Player 2" should {
      "be displayed as a red cell" in {
        Cell(Chip.RED).toString() should be(s"${RED_B}" + s"   ")
      }
    }
    "created with default value" should {
      "have an EMPTY chip" in {
        val cell = Cell()
        cell.chip shouldEqual Chip.EMPTY
      }
    }
  }
}
