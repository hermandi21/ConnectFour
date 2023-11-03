package de.htwg.se.ConnectFour.controller

import scala.util.control.Breaks._

class GameLogic {

  val rows = 6
  val columns = 7
  val board = Array.ofDim[Char](rows, columns)
  var currentPlayer = 'X'

  for (row <- 0 until rows; col <- 0 until columns) {
    board(row)(col) = ' '
  }

  def printBoard(): Unit = {
    for (row <- 0 until rows) {
      for (col <- 0 until columns) {
        print(s"| ${board(row)(col)} ")
      }
      println("|")
    }
    println("  1   2   3   4   5   6   7")
  }

  def dropStone(column: Int): Boolean = {
    if (column < 0 || column >= columns) {
      println("Invalid column number. Please choose a column between 1 and 7")
      false
    } else {
      var dropped = false
      var row = rows - 1
      breakable {
        while (row >= 0) {
          if (board(row)(column) == ' ') {
            board(row)(column) = currentPlayer
            dropped = true
            break
          }
          row -= 1
        }
      }

      if (!dropped) {
        println("Column is full. Choose another column.")
      }
      dropped
    }
  }

    // checkWin-Methode außerhalb der Schleife deklariert
    def checkWin(board: Array[Array[Char]], player: Char, rows: Int, columns: Int): Boolean = {
      var isWin = false
      def checkWin(board: Array[Array[Char]], player: Char, rows: Int, columns: Int): Boolean = {
    var isWin = false

    // Überprüfung auf horizontale Gewinnmuster
    for (row <- 0 until rows; col <- 0 to columns - 4) {
      if (board(row)(col) == player && board(row)(col + 1) == player &&
          board(row)(col + 2) == player && board(row)(col + 3) == player) {
        isWin = true
      }
    }

    // Überprüfung auf vertikale Gewinnmuster
    for (row <- 0 to rows - 4; col <- 0 until columns) {
      if (board(row)(col) == player && board(row + 1)(col) == player &&
          board(row + 2)(col) == player && board(row + 3)(col) == player) {
        isWin = true
      }
    }

    // Überprüfung auf diagonale Gewinnmuster (von links oben nach rechts unten)
    for (row <- 0 to rows - 4; col <- 0 to columns - 4) {
      if (board(row)(col) == player && board(row + 1)(col + 1) == player &&
          board(row + 2)(col + 2) == player && board(row + 3)(col + 3) == player) {
        isWin = true
      }
    }

    // Überprüfung auf diagonale Gewinnmuster (von rechts oben nach links unten)
    for (row <- 0 to rows - 4; col <- 3 until columns) {
      if (board(row)(col) == player && board(row + 1)(col - 1) == player &&
          board(row + 2)(col - 2) == player && board(row + 3)(col - 3) == player) {
        isWin = true
      }
    }
    isWin
  }
      def playGame(): Unit = {
        var gameWon = false
        var moves = 0

        while (!gameWon && moves < rows * columns) {
          println(s"Player $currentPlayer's turn. Enter the column number (1-7):")
          val input = scala.io.StdIn.readInt()

          if (dropStone(input - 1)) {
            moves += 1
            printBoard()
            val isWin = checkWin(board, currentPlayer, rows, columns)

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
      isWin
 }
}