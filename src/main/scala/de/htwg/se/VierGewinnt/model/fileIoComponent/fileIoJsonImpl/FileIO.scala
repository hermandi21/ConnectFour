package de.htwg.se.VierGewinnt.model.fileIoComponent.fileIoJsonImpl

import play.api.libs.json.*
import de.htwg.se.VierGewinnt.model.fileIoComponent.FileIOInterface
import de.htwg.se.VierGewinnt.model.gridComponent.GridInterface
import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.{Cell, Chip, Grid}
import de.htwg.se.VierGewinnt.model.playgroundComponent.PlaygroundInterface
import de.htwg.se.VierGewinnt.model.playgroundComponent.playgroundBaseImpl.{PlaygroundPvE, PlaygroundPvP}
import de.htwg.se.VierGewinnt.model.playerComponent.playerBaseImpl.{BotPlayer, HumanPlayer}


import java.io.PrintWriter
import scala.io.Source
import scala.util.{Failure, Success}

class FileIO extends FileIOInterface {
  override def load: PlaygroundInterface =
    val source: String = Source.fromFile("playground.json").getLines().mkString
    val json: JsValue = Json.parse(source)

    val size = (json \ "playground" \ "size").get.toString.toInt
    val gameType = (json \ "playground" \ "gameType").get.toString.toInt
    val player1 = (json \ "playground" \ "player1").get.toString().replaceAll("\"","")
    val player2 = (json \ "playground" \ "player2").get.toString().replaceAll("\"","")

    var grid: GridInterface = new Grid(size)

    for (index <- 0 until size * size)
      val row = (json \\ "row") (index).as[Int]
      val col = (json \\ "col") (index).as[Int]
      val chip = (json \\ "chip") (index).as[String]

      var _grid = chip match
        case "EMPTY" => grid.replaceCell(row, col, Cell(Chip.EMPTY))
        case "RED" => grid.replaceCell(row, col, Cell(Chip.RED))
        case "YELLOW" => grid.replaceCell(row, col, Cell(Chip.YELLOW))

      _grid match {
        case Success(value) => grid = value
      }

    val pl1 = (player1.toString().split("&")(0), if (player1.toString().split("&")(1)) == "RED" then Chip.RED else Chip.YELLOW)
    val pl2 = (player2.toString().split("&")(0), if (player2.toString().split("&")(1)) == "RED" then Chip.RED else Chip.YELLOW)
    if (gameType == 0) then
      PlaygroundPvP(grid, List(HumanPlayer(pl1._1, pl1._2), HumanPlayer(pl2._1, pl2._2)))
    else
      PlaygroundPvE(grid, List(HumanPlayer(pl1._1, pl1._2), BotPlayer(pl2._1, pl2._2)))


  override def save(playground: PlaygroundInterface): Unit =
    import java.io._
    val pw = new PrintWriter(new File("playground.json"))
    pw.write(Json.prettyPrint(pgToJson(playground)))
    pw.close()

    def pgToJson(pg: PlaygroundInterface) = {
      Json.obj(
        "playground" -> Json.obj(
          "size" -> JsNumber(pg.size),
          "gameType" -> JsNumber(if pg.isInstanceOf[PlaygroundPvP] then 0 else 1),
          "player1" -> JsString(pg.player(0).getName() + "&" + pg.player(0).getChip()),
          "player2" -> JsString(pg.player(1).getName() + "&" + pg.player(1).getChip()),
          "cells" -> Json.toJson(
            for {
              row <- 0 until pg.size
              col <- 0 until pg.size
            } yield {
              Json.obj(
                "row" -> row,
                "col" -> col,
                "chip" -> pg.grid.getCell(row, col).chip.toString
              )
            }
          )
        )
      )
    }
}