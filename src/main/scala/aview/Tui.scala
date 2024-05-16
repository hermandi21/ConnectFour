package de.htwg.se.VierGewinnt
package aview

import controller.{Controller, GameState}
import model.{Chip, Playground}

import scala.io.StdIn.readLine
import util.Observer

import scala.util.Try


class Tui(controller: Controller) extends Observer :
  controller.add(this)

  def run =
    println("Welcome to 'Vier Gewinnt'\n ")
    prepareGameType()
    getInputAndPrintLoop()


  def prepareGameType(): Unit = 
    println("Please select one of the gametype you want to play. For default settings ('Player' vs. 'Player', grid size=7) press ENTER\n0:'Player vs. Player', 1:'Player vs. Bot', 2:'Bot vs. Bot' ")
    val gameType = readLine()
    gameType match 
      case "" => controller.newGame(0,7)
      case "0" | "1" => 
        println("Type the grid size")
        val size = readLine()
        controller.newGame(gameType.toInt, size.toInt) // TODO:Try-Monad
      case "2" => println("not supported yet")
        prepareGameType()
      case "q" => 
      case _ => prepareGameType()

  def getInputAndPrintLoop(): Unit =
    val input = readLine
    input match {
      case "q" => //Exit
      case x if x.toIntOption == None =>
        println("doesn't look like a number")
        getInputAndPrintLoop()
      case x if x.toInt < 1 || x.toInt > controller.playground.size =>
        println("wrong input, try a number from 1 to " + controller.playground.size)
        getInputAndPrintLoop()
      case _ =>
        controller.insertChip(input.toInt - 1)
        getInputAndPrintLoop()
    }

  override def update: Unit = {
    println(controller.toString + "\n")
    controller.printState
  }
    



