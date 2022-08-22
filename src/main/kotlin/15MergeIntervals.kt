import kotlin.math.max
import kotlin.math.min

// From https://leetcode.com/problems/merge-intervals/
object MergeIntervals {
    @JvmStatic
    fun main(args: Array<String>) {
        println(merge(listOf(Pair(1, 3), Pair(2, 6), Pair(8, 10), Pair(15, 18))))
// [[1,6],[8,10],[15,18]]
        println(merge(listOf(Pair(1, 4), Pair(4, 5))))
// [[1,5]]
    }

    fun merge(intervals: List<Pair<Int, Int>>): List<Pair<Int, Int>> =
        intervals
            .mapNotNull { intervalA ->
                intervals
                    .find { intervalB ->
                        intervalA != intervalB && intervalA overlap intervalB
                    }
                    ?.let { intervalB -> intervalA merge intervalB }
                    ?: intervalA
            }
            .distinct()


    infix fun Pair<Int, Int>.overlap(x: Pair<Int, Int>): Boolean = x.first <= this.second && x.second >= this.first

    infix fun Pair<Int, Int>.merge(x: Pair<Int, Int>): Pair<Int, Int> {
        val lowest = min(this.first, x.first)
        val highest = max(this.second, x.second)
        return Pair(lowest, highest)
    }
}
