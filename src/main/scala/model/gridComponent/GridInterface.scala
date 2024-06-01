package de.htwg.se.VierGewinnt.model.gridComponent

import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.{Cell, Chip}


trait GridInterface:   
    def getCell(row: Int, col: Int): Cell    
    def get2DVector(): Vector[Vector[Cell]]
    def replaceCell(row: Int, col: Int, cell: Cell): Try[Grid]
    def removeCellRisk(row: Int, col: Int, cell: Cell): GridInterface
    def checkFull(): Boolean
    def checkWin(): Option[Int]
    def checkFour(a1:Int, a2:Int, b1:Int, b2:Int, c1:Int, c2:Int, d1:Int, d2:Int): Int
    def checkHorizontalWin(): Int
    def checkVerticalWin(): Int
    def checkDiagonalUpRightWin(): Int
    def checkDiagonalUpLeftWin(): Int
    var size: Int = 0
