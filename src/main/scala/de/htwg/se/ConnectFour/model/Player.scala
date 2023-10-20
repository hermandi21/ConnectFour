package de.htwg.se.ConnectFour.model

case class Player(name: String) {
    override def toString(): String = name
}