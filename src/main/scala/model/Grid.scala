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

    def checkFull(): Boolean = {
        //if any of the top rows is not full => false
        //if any of the top rows is full      => true
        var result = true
        for (i <- 0 to size - 1) yield {
            result = if (getCell(i, size - 1).value.getValue == 0) false else result
        }
        result
    }

    def checkWin(): Int = {
        //return 0 = none
        //return 1 = red
        //return 2 = yellow
        var result = 0
        //checkHorizontal
        result match {
            case 0 => result = checkHorizontalWin()
           // case _ => result
        }
        //checkVerticalWin()
        result match {
            case 0 => result = checkVerticalWin()
            case _ => result
        }
        //checkDiagonalUpRight
        result match {
            case 0 => result = checkDiagonalUpRightWin()
            case _ => result
        }
        //checkDiagonalUpLeftWin
        result match {
            case 0 => result = checkDiagonalUpLeftWin()
            case _ => result
        }
        result
    }

    def checkFour(a1: Int, a2: Int, b1: Int, b2: Int, c1: Int, c2: Int, d1: Int, d2: Int): Int = {
        val check = getCell(a1,a2).value.getValue
        
        if((getCell(b1,b2).value.getValue == check)
        &&(getCell(c1,c2).value.getValue == check)
        &&(getCell(d1,d2).value.getValue == check)) {
            check
        } else {
            0
        }
    }

    def checkHorizontalWin():Int = {
        var result = 0;
        for(y <- 0 to (size - 4)) yield { //Height
            for(x <- 0 to (size - 1)) yield { //Width
                var tmp = checkFour(x,y,x,y+1,x,y+2,x,y+3) //tmp - temporary result

                if(tmp != 0) {
                    result = tmp
                }
            }
        }
        result
    }


    def checkVerticalWin():Int = {
        var result = 0;
        for(y <- 0 to (size - 4)) yield { //Height
            for(x <- 0 to (size - 1)) yield { //Width
                var tmp = checkFour(x,y,x+1,y,x+2,y,x+3,y) //tmp - temporary result

                if(tmp != 0) {
                    result = tmp
                }
            }
        }
        result
    }

    def checkDiagonalUpRightWin():Int = {
        var result = 0;
        for(y <- 0 to (size - 4)) yield { //Height
            for(x <- 0 to (size - 1)) yield { //Width
                var tmp = checkFour(x,y,x+1,y+1,x+2,y+2,x+3,y+3) //tmp - temporary result

                if(tmp != 0) {
                    result = tmp
                }
            }
        }
        result
    }

    def checkDiagonalUpLeftWin(): Int = {
    var result = 0;
    for (y <- 0 to (size - 4)) yield { //Height
      for (x <- 3 to (size - 1)) yield { //Width
        var tempres = checkFour(x,y,x-1,y+1,x-2,y+2,x-3,y+3)
        if (tempres != 0) {
          result = tempres
        }
      }
    }
    result
  }

val size = grid.size

}
