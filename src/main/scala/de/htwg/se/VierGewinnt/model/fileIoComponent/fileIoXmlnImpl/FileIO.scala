package de.htwg.se.VierGewinnt.model.fileIoComponent.fileIoXmlnImpl

import com.google.inject.Guice
import de.htwg.se.VierGewinnt.VierGewinntModule
import de.htwg.se.VierGewinnt.model.fileIoComponent.FileIOInterface
import de.htwg.se.VierGewinnt.model.gridComponent.GridInterface
import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.{Cell, Chip, Grid}
import de.htwg.se.VierGewinnt.model.playgroundComponent.{PlaygroundInterface, playgroundBaseImpl}
import de.htwg.se.VierGewinnt.model.playgroundComponent.playgroundBaseImpl.{PlaygroundPvE, PlaygroundPvP}
import de.htwg.se.VierGewinnt.model.playerComponent.*
import de.htwg.se.VierGewinnt.model.playerComponent.playerBaseImpl.{BotPlayer, HumanPlayer}

import scala.util.{Failure, Success}
import scala.xml.PrettyPrinter


class FileIO extends FileIOInterface {
  override def load: PlaygroundInterface =
    val file = scala.xml.XML.loadFile("playground.xml")
    val size = file \\ "playground" \ "@size"
    val gameType = file \\ "playground" \ "@gameType"
    val player1 = file \\ "playground" \ "@player1"
    val player2 = file \\ "playground" \ "@player2"

    var grid: GridInterface = new Grid(size.text.toInt)

    val cellNodes = file \\ "cell"
    for (cell <- cellNodes) {
      val row: Int = (cell \\ "@row").text.toInt
      val col: Int = (cell \\ "@col").text.toInt

      var _grid = (cell \\ "@chip").text match
        case "EMPTY" => grid.replaceCell(row, col, Cell(Chip.EMPTY))
        case "RED" => grid.replaceCell(row, col, Cell(Chip.RED))
        case "YELLOW" => grid.replaceCell(row, col, Cell(Chip.YELLOW))

      _grid match
        case Success(g) => grid = g
    }
    
    val pl1 = (player1.text.split("&")(0), if (player1.text.split("&")(1)) == "RED" then Chip.RED else Chip.YELLOW)
    val pl2 = (player2.text.split("&")(0), if (player2.text.split("&")(1)) == "RED" then Chip.RED else Chip.YELLOW)
    if (gameType.text == "0") then
      PlaygroundPvP(grid, List(HumanPlayer(pl1._1, pl1._2), HumanPlayer(pl2._1, pl2._2)))
    else
      PlaygroundPvE(grid, List(HumanPlayer(pl1._1, pl1._2), BotPlayer(pl2._1, pl2._2)))


  override def save(playground: PlaygroundInterface): Unit = saveString(playground)

  def saveString(pg: PlaygroundInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("playground.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(pgToXml(pg))
    pw.write(xml)
    pw.close()
  }

  def pgToXml(pg: PlaygroundInterface) = {
    <playground size={pg.size.toString} gameType={if pg.isInstanceOf[PlaygroundPvP] then "0" else "1"} player1={pg.player(0).getName() + "&" + pg.player(0).getChip()} player2={pg.player(1).getName() + "&" + pg.player(1).getChip()}>
      {gridToXmL(pg.grid)}
    </playground>
  }

  def gridToXmL(grid: GridInterface) =
    for {
      row <- 0 until grid.size
      col <- 0 until grid.size
    } yield {
      <cell row={row.toString} col={col.toString} chip={grid.getCell(row, col).chip.toString}>
      </cell>
    }
}