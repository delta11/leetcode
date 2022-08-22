import kotlin.math.max
import kotlin.math.min

// From https://leetcode.com/problems/insert-interval/

object InsertIntervals {
    @JvmStatic
    fun main(args: Array<String>) {
        println(insert(listOf(Pair(1, 3), Pair(6, 9)), Pair(2, 5)))
// [[1,5],[6,9]]
        println(insert(listOf(Pair(1, 2), Pair(3, 5), Pair(6, 7), Pair(8, 10), Pair(12, 16)), Pair(4, 8)))
// [[1,2],[3,10],[12,16]]
    }

    fun insert(intervals: List<Pair<Int, Int>>, newInterval: Pair<Int, Int>): List<Pair<Int, Int>> =
        intervals
            .map { intervalA ->
                if (intervalA overlap newInterval) {
                    intervalA merge newInterval
                } else intervalA
            }
            .mapIndexedNotNull { index, intervalA ->
                val intervalBIndex = intervals.indexOfFirst { it overlap intervalA }
                when {
                    intervalBIndex == -1 -> intervalA
                    intervalBIndex < index -> null
                    else -> intervals[intervalBIndex] merge intervalA
                }
            }

    infix fun Pair<Int, Int>.overlap(x: Pair<Int, Int>): Boolean = x.first <= this.second && x.second >= this.first

    infix fun Pair<Int, Int>.merge(x: Pair<Int, Int>): Pair<Int, Int> {
        val lowest = min(this.first, x.first)
        val highest = max(this.second, x.second)
        return Pair(lowest, highest)
    }

}
