package de.htwg.se.VierGewinnt.aview

import de.htwg.se.VierGewinnt.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.Chip
import de.htwg.se.VierGewinnt.util.{Move, Observer}
import scala.swing._
import scala.swing.event._

case class GUI(controller: Controller) extends MainFrame with Observer {
  title = "VierGewinnt"
  preferredSize = new Dimension(800, 600)
  controller.add(this)

  var chips = emptyChips()
  var chipGrid = emptyGrid()

  override def update(): Unit = {
    for (i <- chips.indices; j <- chips(i).indices) {
      controller.getChipColor(j, i) match {
        case Chip.EMPTY  => chips(i)(j).background = Color.gray
        case Chip.RED    => chips(i)(j).background = Color.red
        case Chip.YELLOW => chips(i)(j).background = Color.yellow
      }
    }
    repaint()
  }

  menuBar = new MenuBar {
    contents += new Menu("File") {
      contents += new MenuItem(Action("New...") {
        controller.setupGame(0, 0)
      })
      contents += new MenuItem("Save")
      contents += new MenuItem("Load")
    }
    contents += new Menu("Control") {
      contents += new MenuItem(Action("Undo") {
        controller.doAndPublish(controller.undo)
      })
      contents += new MenuItem(Action("Redo") {
        controller.doAndPublish(controller.redo)
      })
    }
    contents += new Menu("Help") {
      contents += new MenuItem("About")
    }
  }

  contents = new BoxPanel(Orientation.Vertical) {
    contents += chipGrid
  }

  def emptyChips(): Array[Array[Panel]] = {
    Array.fill(controller.gridSize, controller.gridSize) {
      new Panel {
        background = Color.gray
        preferredSize = new Dimension(50, 50)
      }
    }
  }

  def emptyGrid(): GridPanel = {
    new GridPanel(controller.gridSize, controller.gridSize) {
      for (i <- chips.indices; j <- chips(i).indices) {
        val column = i
        listenTo(chips(i)(j).mouse.clicks)
        reactions += {
          case MouseClicked(_, _, _, _, _) =>
            controller.doAndPublish(controller.insChip, Move(column))
        }
        contents += chips(i)(j)
      }
    }
  }

  visible = true
  controller.setupGame(0, 7)
}

object VierGewinnt {
  def main(args: Array[String]): Unit = {
    val controller = new Controller
    val gui = new GUI(controller)
  }
}
