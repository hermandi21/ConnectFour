package de.htwg.se.ConnectFour.controller

import de.htwg.se.ConnectFour
import scala.util.control.Breaks._

class GameLogic {
    
    def checkWin(board: Array[Array[Char]], currentPlayer: Char, rows: Int, columns: Int): Boolean = {
    val directions = List((0, 1), (1, 0), (1, 1), (-1, 1)) // horizontal, vertical, diagonal right, diagonal left

    for {
        row <- 0 until rows
        column <- 0 until columns
        if board(row)(column) == currentPlayer
        (dx, dy) <- directions
    } {
        breakable {
        var count = 1 // At least one stone found in the current direction

        for (i <- 1 to 3) { // Check the next 3 positions
            val newRow = row + i * dx
            val newColumn = column + i * dy

            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
            if (board(newRow)(newColumn) == currentPlayer) {
                count += 1
            } else {
                break // Exit the loop if the sequence is broken
            }
            } else {
            break // Exit the loop if we are out of bounds
            }
        }

        if (count == 4) {
            return true // Four in a row found
        }
        }
    }

    false // No win found
    }

}
