/**
 * FROM https://leetcode.com/problems/missing-number/
 */

object MissingNumber {
    @JvmStatic
    fun main(args: Array<String>) {
        println(missingNumber(listOf(3, 0, 1)))
        // Expected 2

        println(missingNumber(listOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
        // Expected 8
    }

    fun missingNumber(nums: List<Int>): Int {
        val min = nums.minOf { it }
        val max = nums.maxOf { it }

        val missing = (min..max)
            .filter { it !in nums }

        return when (missing.size) {
            1 -> missing.first()
            0 -> throw IllegalArgumentException("All numbers within range [$min] and [$max] accounted for")
            else -> throw IllegalArgumentException("Too multiple missing numbers found [${missing.size}]")
        }
    }
}



