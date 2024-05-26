package de.htwg.se.VierGewinnt.model

import scala.io.AnsiColor.BLUE_B
import scala.io.AnsiColor.RESET

trait PlaygroundTemplate {
    val grid: Grid 
    val player : List[Player]

    val size: Int = grid.size
    val error = ""

    def insertChip(col: Int): PlaygroundTemplate

    def takeAwayChip(col: Int): PlaygroundTemplate

    //get the position where the player wants to drop the chip
    def getDeletePosition(col: Int): Int = {
        var i = size - 1
        while (i >= 0 && grid.getCell(i, col).value != Chip.EMPTY) i-=1
        i += 1
        i match {
            case this.size => this.size - 1
            case _         => i 
        }
    }

    def getPosition(col: Int): Int = {
        var i = size - 1
        while(i >= 0 && grid.getCell(i, col).value != Chip.EMPTY) 
        i -= 1
        i
    }

    override def toString(): String = {
        val box = "It's your turn " + player(0) + "\n" + colnames() + grid + border()
        return if (error != "") error else box //print the col is full-error if needed
    }

    def colnames(): String = {
        val cols = for {
            n <- 1 to size
        } yield n 
        return s"${BLUE_B}\t}" + cols.mkString("\t") + s"\t ${RESET}\n"
    }

    def border(): String = {
        return s"{BLUE_B}   " + ("----" * size) + s"- ${RESET}\n"
    }
}
