package de.htwg.se.VierGewinnt
package aview

import controller.Controller
import model.{Player, Playground, Chip}
import scala.io.StdIn.readLine
import util.Observer

import scala.util.Try


class Tui(controller: Controller) extends Observer :
  controller.add(this)
  val size = 7

  def run =
    println("Welcome to 'Vier Gewinnt'\n $controller ")
    getInputAndPrintLoop()

  def getInputAndPrintLoop(): Unit =
    val input = readLine

    input match {
      case "q" => // Exit
      case x if x.toIntOption == None =>
        println("doesn't look like a number")
        getInputAndPrintLoop()
    }

  override def update: Unit = println(controller.toString)



