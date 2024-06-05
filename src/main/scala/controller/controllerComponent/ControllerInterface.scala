package de.htwg.se.VierGewinnt.controller.controllerComponent

import de.htwg.se.VierGewinnt.controller.controllerComponent.controllerBaseImpl.GameState
import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.Chip
import de.htwg.se.VierGewinnt.model.playerComponent.PlayerInterface
import de.htwg.se.VierGewinnt.model.playgroundComponent.PlaygroundInterface
import de.htwg.se.VierGewinnt.util.Move

trait ControllerInterface():
  def gridSize: Int
  def setupGame(gameType: Int, size: Int): Unit
  def doAndPublish(doThis: Move => PlaygroundInterface, move: Move): Unit
  def doAndPublish(doThis: => PlaygroundInterface): Unit
  def undo: PlaygroundInterface
  def redo: PlaygroundInterface
  def insChip(move: Move):PlaygroundInterface
  def checkFull(): Unit
  def checkWinner(pg: PlaygroundInterface): Unit
  def getChipColor(row: Int, col: Int): Chip
  def printState: Unit
  var gamestate: GameState = GameState()
  var player: List[PlayerInterface] = List()