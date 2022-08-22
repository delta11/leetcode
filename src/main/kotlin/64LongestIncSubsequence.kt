/**
 * FROM https://leetcode.com/problems/longest-increasing-subsequence/
 */

object LongestIncSubsequence {
    @JvmStatic
    fun main(args: Array<String>) {
        println(lengthOfLIS(listOf(10, 9, 2, 5, 3, 7, 101, 18)))
        // Expected 4

        println(lengthOfLIS(listOf(0, 1, 0, 3, 2, 3)))
        // Expected 4

        println(lengthOfLIS(listOf(7, 7, 7, 7, 7, 7, 7)))
        // Expected 1
    }

    fun lengthOfLIS(nums: List<Int>): Int {
        val sortedAndUnique = nums.sorted().distinct()

        return (1..sortedAndUnique.size)
            .flatMap { size ->
                sortedAndUnique.windowed(size, partialWindows = true)
            }
            .map { num ->
                var prev = 0
                num.takeWhile { prev < it.also { prev = it } }.count()
            }
            .maxOf { it }
    }

}



