// From: https://leetcode.com/problems/number-of-islands/?envType=list&envId=xi4ci4ig

object `43Islands` {

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            numIslands(
                listOf(
                    listOf('1', '1', '1', '1', '0'),
                    listOf('1', '1', '0', '1', '0'),
                    listOf('1', '1', '0', '0', '0'),
                    listOf('0', '0', '0', '0', '0'),
                )
            )
        ) // Expected 1


        println(
            numIslands(
                listOf(
                    listOf('1', '1', '0', '0', '0'),
                    listOf('1', '1', '0', '0', '0'),
                    listOf('0', '0', '1', '0', '0'),
                    listOf('0', '0', '0', '1', '1')
                )
            )
        ) // Expected 3
    }

    private fun numIslands(orgGrid: List<List<Char>>): Int {
        val grid = orgGrid.map { x ->
            x.map { it == '1' }
        }

        val landCoordinates = mutableSetOf<Coordinate>()

        return grid.flatMapIndexed { y, yAxis ->
            List(yAxis.size) { x ->
                val coord = Coordinate(x, y)
                if (grid.isLand(coord) && coord !in landCoordinates) { // Island found and it's new
                    val island = exploreIsland(grid, coord)
                    landCoordinates.addAll(island)
                    true
                } else {
                    false
                }
            }
        }.count { it }
    }

    private fun exploreIsland(grid: List<List<Boolean>>, coord: Coordinate): List<Coordinate> {
        return if (grid.isLand(coord)) {
            listOf(coord) +// This coord + look right + look down, ignoring looking left again for brevity
                    exploreIsland(grid, Coordinate(coord.x + 1, coord.y)) +
                    exploreIsland(grid, Coordinate(coord.x, coord.y + 1))
        } else listOf()
    }

    data class Coordinate(val x: Int, val y: Int)

    private fun List<List<Boolean>>.isLand(coord: Coordinate): Boolean =
        this.getOrNull(coord.y)?.getOrNull(coord.x) ?: false // Using null for boundary safety
}

