package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.model._
//import de.htwg.se.ConnectFour.util._
import de.htwg.se.ConnectFour.view.Tui
import de.htwg.se.ConnectFour.view.numRows
import de.htwg.se.ConnectFour.view.numCols


def main(args: Array[String]): Unit = {
  
    println("Welcome to Connect Four!")
    println("To play, enter the column number (1-7) to drop your token.")

    val numRows = 6
    val numCols = 7
    val emptyField = Vector.fill(numRows)(Vector.fill(numCols)(" "))
    val matchfield = MatchfieldModel(emptyField)
    println(matchfield)

  }
  
