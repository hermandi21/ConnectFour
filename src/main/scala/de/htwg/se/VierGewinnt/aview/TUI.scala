package de.htwg.se.VierGewinnt
package aview

import de.htwg.se.VierGewinnt.controller.controllerComponent.ControllerInterface
import scala.io.StdIn.readLine
import util.{Move, Observer}

import scala.util.Try


class TUI(controller: ControllerInterface)extends Observer :
  controller.add(this)

  def run =
    println(s"Welcome to 'Vier Gewinnt'\n")
    prepareGameType()
    getInputAndPrintLoop()

  def prepareGameType(): Unit =
    println("Please select one of the game type you want to play. For default settings ('Player vs Player', grid size=7) press ENTER\n0:'Player vs. Player', 1:'Player vs. Bot', 2:'Bot vs. Bot'")
    val gameType = readLine()
    if (controller.isPreparing) //If controller is not preparing anymore, skip this
      gameType match
        case "" => controller.setupGame(0, 7)
        case "0" | "1" =>
          println("Type the grid size")
          val size = readLine()
          controller.setupGame(gameType.toInt, size.toInt)
        case "2" => println("not supported yet")
          prepareGameType()
        case "save" =>
          controller.save
          println("Game saved.")
          prepareGameType()
        case "load" =>
          controller.load
          println("Game loaded.")
        case "q" => //Exit
        case _   => prepareGameType()

  def getInputAndPrintLoop(): Unit =
    val input = readLine()
    input match {
      case "q" => //Exit
      case "restart" =>
        controller.restartGame
        prepareGameType();
        getInputAndPrintLoop()
      case "undo" =>
        controller.doAndPublish(controller.undo);
        getInputAndPrintLoop()
      case "redo" =>
        controller.doAndPublish(controller.redo);
        getInputAndPrintLoop()
      case "save" =>
        controller.save
        println("Game saved.")
        getInputAndPrintLoop()
      case "load" =>
        controller.load
        println("Game loaded.")
        getInputAndPrintLoop()
      case x if x.toIntOption == None =>
        println("doesn't look like a number")
        getInputAndPrintLoop()
      case x if x.toInt < 1 || x.toInt > controller.playground.size =>
        println("wrong input, try a number from 1 to " + controller.playground.size)
        getInputAndPrintLoop()
      case _ =>
        controller.doAndPublish(controller.insChip, Move(input.toInt - 1))
        getInputAndPrintLoop()
    }

  override def update: Unit = {
    println(controller.toString)
    println(controller.printState)
  }