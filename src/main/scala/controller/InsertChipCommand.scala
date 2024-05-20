package de.htwg.se.VierGewinnt.controller

import model.PlaygroundTemplate


class InsertChipCommand(move: Move) extends Command[PlaygroundTemplate]:
  override def noStep(playground: PlaygroundTemplate): PlaygroundTemplate = playground
  override def doStep(playground: PlaygroundTemplate): PlaygroundTemplate = playground.insertChip(move.col)
  override def undoStep(playground: PlaygroundTemplate): PlaygroundTemplate = playground.takeAwayChip(move.col)
  override def redoStep(playground: PlaygroundTemplate): PlaygroundTemplate = playground.insertChip(move.col)



