import org.scalatest._
import org.scalatest.matchers.should.Matchers
import de.htwg.se.ConnectFour.view.Tui
import org.scalatest.flatspec.AnyFlatSpecLike

class TuiSpec extends AnyFlatSpecLike with Matchers {
  "A Tui" should "print a game board with 6 rows and 7 columns" in {
    val tui = new Tui
    val expectedBoard =
      """
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      ||   |   |   |   |   |   |   |
      |+---+---+---+---+---+---+---+
      | 1   2   3   4   5   6   7 
      """.stripMargin.trim()

    val printedBoard = tui.printGameBoard(6, 7).trim()
    printedBoard shouldBe expectedBoard
  }

  it should "be able to print a flexible board" in {
    val tui = new Tui()
    val printedBoard = tui.printGameBoard(3, 5).trim()

    val expectedBoard =
      """
      |+---+---+---+---+---+
      ||   |   |   |   |   |
      |+---+---+---+---+---+
      ||   |   |   |   |   |
      |+---+---+---+---+---+
      ||   |   |   |   |   |
      |+---+---+---+---+---+
      | 1   2   3   4   5 
      """.stripMargin.trim()

    printedBoard shouldBe expectedBoard
  }

}
