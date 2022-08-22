// From https://leetcode.com/problems/container-with-most-water/

fun main() {
    println(mostWater(listOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) // 49
    println(mostWater(listOf(1, 1))) // 1
    println(mostWater(listOf(4, 3, 2, 1, 4))) // 16
    println(mostWater(listOf(1, 2, 1))) // 2
}

fun mostWater(heights: List<Int>): Int =
    IntRange(1, heights.size)
        .flatMap { size -> heights.windowed(size) }
        .map { windowBuckets -> minOf(windowBuckets.first(), windowBuckets.last()) * (windowBuckets.size - 1) }
        .maxOrNull() ?: 0
