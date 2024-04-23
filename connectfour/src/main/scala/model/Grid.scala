package de.htwg.se.VierGewinnt.model

import io.AnsiColor.*

case class Grid(grid: Vector[Vector[Cell]]) {

    def this(size: Int = 7) = this(Vector.tabulate(size, size)((row, col) => Cell(Chip.EMPTY))) 

    def getCell(row:Int, col:Int): Cell = {
        grid(row)(col)
    }

    def replaceCell(row: Int, col: Int, cell: Cell): Grid = {
        copy(grid.updated(row, grid(row).updated(col, cell)))
    }

    val size: Int = grid.size

    override def toString(): String = {
        var out = ""
        grid.foreach {
            (row:Vector[Cell]) => 
                out = out + s"${BLUE_B} "
                row.foreach{ (cell:Cell) => 
                    out = out + s"${BLUE_B}| " + cell
                }
                out = out + s"${BLUE_B}| {$RESET} \n"
        }
        return out
    }
}
