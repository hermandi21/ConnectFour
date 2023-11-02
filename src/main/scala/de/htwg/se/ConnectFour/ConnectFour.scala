package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.view.Tui
import de.htwg.se.ConnectFour.controller.* 

object ConnectFour {
  def main(args: Array[String]): Unit = {
    val rows = 6
    val columns = 7
    val board = Array.ofDim[Char](rows, columns)
    var currentPlayer = 'X'
    val gameLogic = new GameLogic()

    // Initialize the board with empty spaces
    for (row <- 0 until rows; col <- 0 until columns) {
      board(row)(col) = ' '
    }

    // Function to print the board
    def printBoard(): Unit = {
      for (row <- 0 until rows) {
        for (col <- 0 until columns) {
          print(s"| ${board(row)(col)} ")
        }
        println("|")
      }
      println("  1   2   3   4   5   6   7")
    }

   // Function to drop a stone in a column
    def dropStone(column: Int): Boolean = {
      if (column < 0 || column >= columns) {
        println("Invalid column number. Please choose a column between 1 and 7")
        false
      } else {
        var dropped = false
        var row = rows -1
        while (row < rows && board(row)(column) != ' ') {
          row -= 1
        }
        
        if (row < rows) {
          board(row)(column) = currentPlayer
          dropped = true
        } else {
          println("Column is full. Choose another column.")
        }
        dropped
      }
    }


    // Game loop
    var gameWon = false
    var moves = 0
    val isWin = gameLogic.checkWin(board, currentPlayer, rows, columns)

    while (!gameWon && moves < rows * columns) {
      println(s"Player $currentPlayer's turn. Enter the column number (1-7):")
      val input = scala.io.StdIn.readInt()

      if (dropStone(input - 1)) {
        moves += 1
        printBoard()

        if (isWin) {
          println(s"Player $currentPlayer wins!")
          gameWon = true
        } else {
          currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        }
      }
    }

    if (!gameWon) {
      println("It's a draw!")
    }
  }
}
