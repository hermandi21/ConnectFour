package de.htwg.se.VierGewinnt.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

import io.AnsiColor.*
import scala.math.ceil

class PlaygroundSpec extends AnyWordSpec {
  "Playground is the representation of the gamefield" when {
    "initialized without parameter" should {
      val playground = new Playground()
      "have the default size" in {
        playground.size should be(7)
      }
      val playgroundcpy = playground.insertChip(0)
      "Player should insert a chip in a choosen column" in {
        playgroundcpy.grid.getCell(playgroundcpy.size - 1, 0).chip should be(Chip.YELLOW)
      }
      "request how many chips inserted in a column" in {
        playgroundcpy.getPosition(0) should be(playgroundcpy.size - 2)
      }
    }
    "have a String representation with a head, grid and border" should {
      val playground = new Playground(7)
      "have a line with column names" in {
        playground.colnames() should be(s"${BLUE_B}\t1\t2\t3\t4\t5\t6\t7\t ${RESET}\n")
      }
      "have a bottom border" in {
        playground.border() should be(s"${BLUE_B}  -----------------------------  ${RESET}\n")
      }
      "should print the whole gamefield" in {
        playground.toString should be("It's your turn " + playground.player(0) + "\n" + playground.colnames() + playground.grid + playground.border())
      }
    }
    "when a column is full" should {
      val playground = new Playground(1)
      val playgroundfull = playground.insertChip(0)
      "nothing happen" in {
        playgroundfull.insertChip(0) should be(playgroundfull)
      }
      "print that the col is full" in {
        playgroundfull.insertChip(0).error = "This column is full try another one"
      }
    }
    "when a changing the enemy strategy" should {
      val playground = new Playground(1)
      "change to person" in {
        val playgroundtemp = playground.setEnemyStrategy("person")
        playgroundtemp      }
      "change to computer" in {
        val playgroundtemp = playground.setEnemyStrategy("computer")
        playgroundtemp.enemStrat should be (EnemyComputerStrategy())
      }
      "change not by faulty input" in {
        val playgroundtemp = playground.setEnemyStrategy("error")
        playgroundtemp.enemStrat should be (EnemyPersonStrategy())
      }
    }
  }
}