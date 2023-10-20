import de.htwg.se.ConnectFour.model.Player
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class PlayerSpec extends AnyFlatSpec with Matchers {

    "Player" should "be printed correctly" in {
        val player = Player("Andreas")
        player.toString() should be ("Andreas")
    }

    "Player1" should "be equal to the player with the same name" in {
        val player1 = Player("Alice")
        val player2 = Player("Alice")
        player1 should be equals (player2)
    }
    

}
