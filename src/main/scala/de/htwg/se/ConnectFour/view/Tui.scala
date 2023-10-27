package de.htwg.se.ConnectFour.view

import de.htwg.se.ConnectFour.model.MatchfieldModel

val numRows = 6
val numCols = 7

class Tui(matchfield: MatchfieldModel[Any]) {

  def displayMatchfield(): Unit = {
    println(matchfield)
  }

  def displayMessage(message: String): Unit = {
    println(message)
  }

  def getUserInput(): Int = {
    try {
      val numCols = matchfield.rows.headOption.map(_.size).getOrElse(0)
      print(s"Enter the column (1-$numCols) to drop your token: ")
      val input = scala.io.StdIn.readInt()
      if (input >= 1 && input <= numCols) {
        input
      } else {
        displayMessage(s"Invalid input. Please enter a column number (1-$numCols).")
        getUserInput()
      }
    } catch {
      case _: NumberFormatException =>
        displayMessage(s"Invalid input. Please enter a column number (1-$numCols).")
        getUserInput()
    }
  }
}
