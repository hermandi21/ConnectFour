package de.htwg.se.ConnectFour.view

class Tui {

  def printGameBoard(rows: Int, columns: Int): String = {
    val board = new StringBuilder

    for (i <- 1 to rows) {
      board.append("+" + "---+" * columns + "\n")
      board.append("|" + "   |" * columns + "\n")
    }
    board.append("+" + "---+" * columns + "\n")

    // Spaltennummern horizontal ausgeben
    for (col <- 1 to columns) {
      board.append(s" $col  ")
    }
    board.append("\n")

    board.toString()
  }

  def createEmptyBoard(rows: Int, cols: Int): Array[Array[Int]] = {
    Array.ofDim[Int](rows, cols)
  }

    def cell(rows:Int, cols:Int): Any = (rows,cols)
}





