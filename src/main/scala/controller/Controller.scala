package de.htwg.se.VierGewinnt
package controller

import model._
import util.Command
import util.Observable
import util.UndoManager

class Controller(var playground: PlaygroundTemplate, var gameType: Int) extends Observable :
  //initialisiert die Spieler und den gameType '0: PvP' '1: PvE' '2: idk'
  def this(size: Int = 7) = this(PlaygroundPvP(new Grid(size), List(HumanPlayer("Player 1", Chip.YELLOW),HumanPlayer("Player 2", Chip.RED))),0)

  var gamestate: GameState = GameState()
  var player: List[Player] = List()
  val undoManager = new UndoManager[PlaygroundTemplate]


  def setupGame(gameType: Int, size: Int): Unit =
    gameType match 
      case 0 =>
        player = List(HumanPlayer("Player 1", Chip.YELLOW), HumanPlayer("Player 2", Chip.RED))
        playground = PlaygroundPvP(new Grid(size), player)
      case 1 =>
        player = List(HumanPlayer("Player 1", Chip.YELLOW), BotPlayer("Bot 1", Chip.RED))
        playground = PlaygroundPvE(new Grid(size), player)
    gamestate.changeState(PlayState())
    notifyObservers

  def doAndPublish(doThis: Move => PlaygroundTemplate, move: Move) =
    playground = doThis(move)
    notifyObservers

  def doAndPublish(doThis: => PlaygroundTemplate) =
    playground = doThis
    notifyObservers

  def undo: PlaygroundTemplate = undoManager.undoStep(playground)

  def redo: PlaygroundTemplate = undoManager.redoStep(playground)

  def insChip(move: Move): PlaygroundTemplate = {
    val temp = undoManager.doStep(playground, InsertChipCommand(move))
    checkWinner(temp)
    checkFull()
    temp
  }

  def checkFull(): Unit = 
    playground.grid.checkFull() match {
      case true => gamestate.changeState(TieState())
      case false => gamestate.changeState(PlayState())
    }

  def checkWinner(pg: PlaygroundTemplate): Unit = 
    pg.grid.checkWin() match {
      case None => 
      case Some(num) => 
        println(" Winner is " + num)
        gamestate.changeState(WinState())
    }
  
  def printState: Unit = gamestate.displayState()

  override def toString = playground.toString