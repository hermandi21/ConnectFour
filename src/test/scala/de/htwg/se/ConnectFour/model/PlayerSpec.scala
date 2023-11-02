package de.htwg.se.ConnectFour.model

import org.scalatest.funsuite.AnyFunSuite
import de.htwg.se.ConnectFour.model.{Player, RealPlayer}

class PlayerTest extends AnyFunSuite {

  test("RealPlayer sollte korrekt erstellt werden") {
    val player = RealPlayer("Alice", 'X')
    
    assert(player.name == "Alice")
    assert(player.sign == 'X')
  }

  test("RealPlayer sollte eine lesbare Zeichenfolge darstellen") {
    val player = RealPlayer("Bob", 'O')
    
    assert(player.toString() == "O")
  }
}

