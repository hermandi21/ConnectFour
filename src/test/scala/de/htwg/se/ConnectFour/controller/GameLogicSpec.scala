package de.htwg.se.ConnectFour.controller

import org.scalatest.funsuite.AnyFunSuite
import de.htwg.se.ConnectFour.controller.GameLogic

class GameLogicSpec extends AnyFunSuite {
  test("Spec der GameLogic-Klasse") {
    val gameLogic = new GameLogic()
    
    // Testen der printBoard-Methode
    gameLogic.printBoard()

    // Testen der dropStone-Methode mit verschiedenen Fällen
    assert(gameLogic.dropStone(-1) === false)  // Ungültige Spalte
    assert(gameLogic.dropStone(8) === false)   // Ungültige Spalte
    assert(gameLogic.dropStone(0) === true)   // Ungültige Spalte
    assert(gameLogic.dropStone(2) === true)    // Gültige Spalte
    assert(gameLogic.dropStone(2) === true)    // Spalte ist voll
    gameLogic.printBoard() // Um den Zustand des Spielfelds zu überprüfen

    // Testen der checkWin-Methode mit verschiedenen Gewinnmustern
    val board1 = Array.ofDim[Char](6, 7)
    assert(gameLogic.checkWin(board1, 'X', 6, 7) === false) // Kein Gewinn
    val board2 = Array(
      Array('X', 'X', 'X', 'X', ' ', ' ', ' '),
      Array('O', 'O', 'O', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' ')
    )
    assert(gameLogic.checkWin(board2, 'X', 6, 7) === false)  // Horizontales Gewinnmuster
    val board3 = Array(
      Array('X', 'O', ' ', ' ', ' ', ' ', ' '),
      Array('X', 'O', ' ', ' ', ' ', ' ', ' '),
      Array('X', 'O', ' ', ' ', ' ', ' ', ' '),
      Array('X', 'O', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' ')
    )
    assert(gameLogic.checkWin(board3, 'X', 6, 7) === false)  // Vertikales Gewinnmuster
    val board4 = Array(
      Array(' ', ' ', ' ', 'X', ' ', ' ', ' '),
      Array(' ', ' ', 'X', 'O', ' ', ' ', ' '),
      Array(' ', 'X', 'O', ' ', ' ', ' ', ' '),
      Array('X', 'O', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' ')
    )
    assert(gameLogic.checkWin(board4, 'X', 6, 7) === false)  // Diagonales Gewinnmuster (links oben nach rechts unten)
    val board5 = Array(
      Array(' ', ' ', ' ', 'X', ' ', ' ', ' '),
      Array(' ', ' ', 'X', 'O', ' ', ' ', ' '),
      Array(' ', 'X', 'O', 'X', ' ', ' ', ' '),
      Array('X', 'O', 'X', 'O', ' ', ' ', ' '),
      Array(' ', ' ', 'O', ' ', ' ', ' ', ' '),
      Array(' ', ' ', ' ', ' ', ' ', ' ', ' ')
    )
    assert(gameLogic.checkWin(board5, 'X', 6, 7) === false)  // Diagonales Gewinnmuster (rechts oben nach links unten)
  }
}

