package de.htwg.se.ConnectFour.model

trait Player {
    val name: String
    val sign: Char

    override def toString() = this.sign.toString()
}

case class HumanPlayer(name: String = "player", sign: Char = 'x') extends Player
