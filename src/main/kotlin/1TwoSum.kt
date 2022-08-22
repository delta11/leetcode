// From https://leetcode.com/problems/two-sum/

fun main() {
    println(twoSumSimple(nums = intArrayOf(2, 7, 11, 15), target = 9).contentToString()) // Expected [0,1]

    println(twoSumSimple(nums = intArrayOf(3, 2, 4), target = 6).contentToString()) // Expected [1,2]

    println(twoSumSimple(nums = intArrayOf(3, 3), target = 6).contentToString()) // Expected [0,1]
}


fun twoSumSimple(nums: IntArray, target: Int): IntArray {
    for ((index, num) in nums.withIndex()) {
        for ((innerIndex, innerNum) in nums.withIndex()) {
            if (index != innerIndex) {
                if (num+innerNum == target) {
                    return intArrayOf(index, innerIndex)
                }
            }
        }
    }

    throw IllegalArgumentException("No match found")
}
