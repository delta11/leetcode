/**
 * https://leetcode.com/problems/set-matrix-zeroes/?envType=list&envId=xi4ci4ig
 */
object SetMatrixZeroes {
    @JvmStatic
    fun main(args: Array<String>) {
        setZeroes(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1),
            )
        ).forEach { println(it.joinToString(",")) }

        println()

        setZeroes(
            arrayOf(
                intArrayOf(0, 1, 2, 0),
                intArrayOf(3, 4, 5, 2),
                intArrayOf(1, 3, 1, 5),
            )
        ).forEach { println(it.joinToString(",")) }
    }

    fun setZeroes(matrix: Array<IntArray>): Array<IntArray> {
        val coordinatesChanged = mutableListOf<Pair<Int, Int>>()
        matrix.forEachIndexed { indexM, m ->
            m.forEachIndexed { indexN, n ->
                if (n == 0 && !coordinatesChanged.contains(Pair(indexM, indexN))) {
                    matrix[indexM] = IntArray(m.size) { 0 }
                    matrix.forEachIndexed { rowIndex, row ->
                        row[indexN] = 0
                        coordinatesChanged.add(Pair(rowIndex, indexN))
                    }
                }
            }
        }
        return matrix
    }
}
