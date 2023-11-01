import org.scalatest._
import org.scalatest.matchers.should.Matchers
import de.htwg.se.ConnectFour.view.Tui
import org.scalatest.flatspec.AnyFlatSpecLike

class TuiSpec extends AnyFlatSpecLike with Matchers {
  "A Connect Four board" should "be able to print a flexible board" in {
    val tui = new Tui()
    val printedBoard = tui.printGameBoard(3,5).trim()
 
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
      """.stripMargin('|').trim()
   
    printedBoard shouldBe (expectedBoard)
  }
  /*
  "a bar" should "look like this"
  val bar = tui.printGameBoard(1,0)
  val tBar = """
  |+---+---+---+---+---+
  """" +
  "*/
}
