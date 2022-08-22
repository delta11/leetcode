// From https://leetcode.com/problems/rotate-image/

fun main() {
    println(rotate(mutableListOf(mutableListOf(1,2,3),mutableListOf(4,5,6), mutableListOf(7,8,9))))
// [[7,4,1],[8,5,2],[9,6,3]]
    println(rotate(mutableListOf(mutableListOf(5,1,9,11),mutableListOf(2,4,8,10), mutableListOf(13,3,6,7),mutableListOf(15,14,12,16))))
// [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
}

fun rotate(matrix: MutableList<MutableList<Int>>): List<List<Int>> {
    val matrixSize = matrix.size
    for (i in 0 until (matrixSize + 1) / 2) {
        for (j in 0 until matrixSize / 2) {
            val temp = matrix[matrixSize - 1 - j][i]
            matrix[matrixSize - 1 - j][i] = matrix[matrixSize - 1 - i][matrixSize - j - 1]
            matrix[matrixSize - 1 - i][matrixSize - j - 1] = matrix[j][matrixSize - 1 - i]
            matrix[j][matrixSize - 1 - i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
    return matrix
}
