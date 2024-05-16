package de.htwg.se.VierGewinnt.model

import de.htwg.se.VierGewinnt.controller.Controller
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.io.AnsiColor.*

class EnemyPersonStrategySpec extends AnyWordSpec {
    "An Enemy Person Spec should work deterministic" when {
        var playground = new Playground()
        "inserting a Chip" in {
            val tmpplayground = playground.setEnemyStrategy("person")
            tmpplayground.insertChip(1) // Überprüfen Sie hier, ob das Einfügen eines Chips korrekt behandelt wird
            // tmpplayground.insertChip(1) should be (Playground(Grid(Vector.tabulate(7, 7)((row, col) => Cell(Chip.EMPTY))).replaceCell(6,1,Cell(Chip.YELLOW)), List(HumanPlayer("Player 2", Chip.RED), HumanPlayer("Player 1", Chip.YELLOW)), EnemyPersonStrategy()))
        }
    }
}
