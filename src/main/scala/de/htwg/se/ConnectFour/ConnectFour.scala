package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.model._
import de.htwg.se.ConnectFour.view.Tui


def main(args: Array[String]): Unit = {
  
    println("\n")
    println("Welcome to Connect Four!")
    println("To play, enter the column number (1-7) to drop your token.\n")
    val tui = new Tui
    val matchfield = tui.printGameBoard(6,7)
  }
  
