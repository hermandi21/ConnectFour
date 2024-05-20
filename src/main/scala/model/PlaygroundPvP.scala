package model

import de.htwg.se.VierGewinnt.util.* 

case class PlaygroundPvP(val grid: Grid, val player: List[Player]) extends PlaygroundTemplate {
    val enemStrat = EnemyPersStrategy()

    override def insertChip(col: Int): PlaygroundTemplate = {
        enemStrat.insertChip(this, col)
    }

    override def takeAwayChip(col: Int): PlaygroundTemplate = {
        PlaygroundPvP(grid.replaceCell(getDeletePosition(col), col, Cell(Chip.EMPTY)).get, player.reverse)
    }
}
