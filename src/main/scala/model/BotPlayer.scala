package model

import de.htwg.se.VierGewinnt.util.EnemyStrategy

import io.AnsiColor.* 

case class BotPlayer(val name: String, val chip: Chip, val strategy: EnemyStrategy) extends Player {
    override def toString(): String = s"${chip.getColorCode}$name${RESET}"
}