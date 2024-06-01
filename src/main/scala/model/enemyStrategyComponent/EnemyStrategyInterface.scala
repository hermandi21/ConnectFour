package model.enemyStrategyComponent

import de.htwg.se.VierGewinnt.model.playgroundComponent.playgroundBaseImpl.PlaygroundTemplate

trait EnemyStrategyInterface {
    def insertChip(pg:PlaygroundTemplate, col: Int): PlaygroundTemplate
    def ComputerinsertChip(pg:PlaygroundTemplate): PlaygroundTemplate
}

