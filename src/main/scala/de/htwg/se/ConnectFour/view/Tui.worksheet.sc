
class Tui {

  def printGameBoard(rows: Int, columns: Int): Unit = {
  for (i <- 1 to rows) {
    println("+" + "---+" * columns)
    println("|" + "   |" * columns)
  }
  println("+" + "---+" * columns)
  
  //Nummerierung der Spalten
  for (columns <- 1 until columns)
    println(s" $columns")
}

  def createEmptyBoard(rows: Int, cols: Int): Array[Array[Int]] = {
    Array.ofDim[Int](rows, cols)
  }

    def cell(rows:Int, cols:Int): Any = (rows,cols)
}





