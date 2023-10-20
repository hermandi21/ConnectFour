package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.model.Player

object ConnectFour {
  def main(args: Array[String]): Unit = {
    val student = Player("Andreas")
    println("Hello, " + student.name)
  }
}
