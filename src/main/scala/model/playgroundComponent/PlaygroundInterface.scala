package model.playgroundComponent

import de.htwg.se.VierGewinnt.model.gridComponent.GridInterface
import de.htwg.se.VierGewinnt.model.playerComponent.PlayerInterface

trait PlaygroundInterface:
    def grid: GridInterface
    def player: List[PlayerInterface]
    def size: Int
    val error: String = ""
    def insertChip(col: Int): PlaygroundTemplate
    def takeAwayChip(col: Int): PlaygroundTemplate
    def getDeletePosition(col: Int): Int
    def getPosition(col: Int): Int
    def colnames(): String
    def border(): String
