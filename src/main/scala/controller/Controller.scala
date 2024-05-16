package de.htwg.se.VierGewinnt
package controller

import model.{Chip, Player, Playground}
import util.Observable

class Controller(var playground: Playground) extends Observable :
  def this(size: Int = 7) = this(new Playground(7))

  def insertChip(col: Int): Unit =    
    playground = playground.insertChip(col)
    
  def checkFull():Unit = 
    playground.grid.checkFull() match {
      case true => println("Grid is completely full")
      case false => println("Grid is not completely full")
    }
      
  def changeEnemyStrategy(strat: String):Unit = 
    playground = playground.setEnemyStrategy(strat)
    
  def checkWinner():Unit =
    playground.grid.checkWin() match
      case 0 => 
      case 1 => println(" Red win's \n")
      case 2 => println(" Yellow win's \n")
    

  override def toString = playground.toString
