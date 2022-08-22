package fourinarow

/**
 * Basic implementation connect 4, 'vier op een rij' in Dutch
 *
 * See attached test for different scenario's being played out
 */
class FourInARowGame(private val input: Input) {

    fun gameLoop(
        currentPlayer: Piece = Piece.RED,
        gameState: GameState = List(8) { List(8) { null } }
    ): Piece {
        println("Player $currentPlayer's turn")
        val selectedColumn = input.askCoordinate()
        if (!validateColumn(selectedColumn, gameState)) {
            return gameLoop(currentPlayer, gameState)
        }
        val foundRow = findRowInColumn(gameState, selectedColumn)

        val updatedGameState = gameState.upsert(x = selectedColumn, y = foundRow, piece = currentPlayer)
        displayGameState(updatedGameState)

        return findWinner(updatedGameState) ?: gameLoop(currentPlayer.flip(), updatedGameState)
    }

    private fun validateColumn(selectedColumn: Int, gameState: GameState): Boolean {
        if (selectedColumn < 0 || selectedColumn >= 8) {
            println("Incorrect input please enter an integer between 0 and 7")
            return false
        }
        if (gameState[selectedColumn].all { it != null }) {
            println("Incorrect input please enter a column that's not full")
            return false
        }
        return true
    }

    private fun findWinner(gameState: GameState): Piece? {
        (0..7).forEach { xAxis ->
            (0..7).forEach { yAxis ->
                val piece = gameState[yAxis][xAxis]
                if (piece != null) {
                    val directionalCheckLambda: (xDelta: Int, yDelta: Int) -> Piece? = { xDelta, yDelta ->
                        if (piece == gameState.getOrNull(yAxis + yDelta)?.getOrNull(xAxis + xDelta) &&
                            piece == gameState.getOrNull(yAxis + (yDelta * 2))?.getOrNull(xAxis + (xDelta * 2)) &&
                            piece == gameState.getOrNull(yAxis + (yDelta * 3))?.getOrNull(xAxis + (xDelta * 3))
                        ) {
                            piece
                        } else null
                    }
                    // Check in every direction
                    directionalCheckLambda(1, 1)?.also { return@findWinner it }
                    directionalCheckLambda(1, -1)?.also { return@findWinner it }
                    directionalCheckLambda(-1, 1)?.also { return@findWinner it }
                    directionalCheckLambda(-1, -1)?.also { return@findWinner it }
                    directionalCheckLambda(0, 1)?.also { return@findWinner it }
                    directionalCheckLambda(1, 0)?.also { return@findWinner it }
                }
            }
        }
        return null
    }

    private fun displayGameState(gameState: GameState) {
        (0..7).forEach { xAxis ->
            (0..7).forEach { yAxis ->
                val cell = gameState[yAxis][xAxis]
                if (cell == null) {
                    print(" ")
                } else {
                    print(cell.name.subSequence(0, 1))
                }
                print("|")
            }
            println()
        }
        println()
    }

    private fun findRowInColumn(gameState: GameState, selectedColumn: Int): Int =
        gameState[selectedColumn].lastIndexOf(null)

    private fun GameState.upsert(x: Int, y: Int, piece: Piece): GameState = this.updated(x, this[x].updated(y, piece))

    private fun <T> Iterable<T>.updated(index: Int, new: T): List<T> = mapIndexed { i, e -> if (i == index) new else e }
}

typealias GameState = List<List<Piece?>>

enum class Piece {
    RED, YELLOW;

    fun flip(): Piece = when (this) {
        RED -> YELLOW
        YELLOW -> RED
    }
}
