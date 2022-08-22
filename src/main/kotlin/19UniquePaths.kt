// From https://leetcode.com/problems/unique-paths/

object UniquePaths {
    @JvmStatic
    fun main(args: Array<String>) {
        println(uniquePaths(3, 7))
        // Expected 28

        println(uniquePaths(3, 2))
        // Expected 3
    }


    fun uniquePaths(width: Int, height: Int): Int {
        val firstPath = findPath(width, height)
        val balance = firstPath.sumOf { it.value }

        return (0 until firstPath.size)
            .flatMap { index ->
                val newList = mutableListOf(*firstPath.toTypedArray())
                val currentPosition = newList[index]
                newList[index] = currentPosition.flip()

                (index+1 until firstPath.size)
                    .map {
                        val secondNewList = mutableListOf(*newList.toTypedArray())
                        val currentPosition = secondNewList[it]
                        secondNewList[index] = currentPosition.flip()
                        secondNewList
                    }
            }
            .filter { path -> path.sumOf { it.value } == balance }
            .onEach { println(it) }
            .count () + 1 // +1 for the first path
    }

    fun findPath(width: Int, height: Int): List<Direction> {
        val pathTaken = mutableListOf<Direction>()
        var currentPosX = 1
        var currentPosY = 1
        var count = 0
        while (currentPosX < width) {
            currentPosX++
            count++
            pathTaken.add(Direction.RIGHT)
        }
        while (currentPosY < height) {
            currentPosY++
            count++
            pathTaken.add(Direction.DOWN)
        }
        return pathTaken
    }

    enum class Direction(val value: Int) {
        DOWN(-1),
        RIGHT(1);

        fun flip() = if (this.value == 1) DOWN else RIGHT
    }
}
