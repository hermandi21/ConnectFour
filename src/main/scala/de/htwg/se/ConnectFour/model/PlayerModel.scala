package de.htwg.se.ConnectFour.model

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

trait PlayerModel {
  val name:String
  val sign:Char

  override def toString: String = this.sign.toString
}

case class RealPlayer(name: String = "player", sign: Char = 'x') extends PlayerModel

