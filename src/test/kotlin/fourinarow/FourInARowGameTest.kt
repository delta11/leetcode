package fourinarow

import io.mockk.every
import io.mockk.mockk
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class FourInARowGameTest {
    private val input = mockk<Input>()
    private val game = FourInARowGame(input)

    @Test
    fun `horizontal victory left bottom hand corner`() {
        every { input.askCoordinate() } returns 0 andThen 4 andThen 1 andThen 5 andThen 2 andThen 6 andThen 3

        val result = game.gameLoop()

        assertThat(result, equalTo(Piece.RED))
    }

    @Test
    fun `horizontal victory right bottom hand corner`() {
        every { input.askCoordinate() } returns 0 andThen 4 andThen 1 andThen 5 andThen 2 andThen 6 andThen 0 andThen 7

        val result = game.gameLoop()

        assertThat(result, equalTo(Piece.YELLOW))
    }

    @Test
    fun `horizontal victory second layer middle`() {
        every { input.askCoordinate() } returnsMany listOf(0, 1, 2, 3, 0, 4, 1, 6, 2, 7, 3)

        val result = game.gameLoop()

        assertThat(result, equalTo(Piece.RED))
    }

    @Test
    fun `diagonal victory`() {
        every { input.askCoordinate() } returnsMany listOf(0, 1, 2, 3, 1, 2, 2, 3, 4, 3)

        val result = game.gameLoop()

        assertThat(result, equalTo(Piece.RED))
    }

    @Test
    fun `vertical victory`() {
        every { input.askCoordinate() } returnsMany listOf(0, 1, 0, 1, 0, 1, 0, 1)

        val result = game.gameLoop()

        assertThat(result, equalTo(Piece.RED))
    }
}
