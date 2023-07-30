import kotlin.math.max

// From: https://leetcode.com/problems/house-robber/?envType=list&envId=xi4ci4ig

object `42HouseRobber` {

    @JvmStatic
    fun main(args: Array<String>) {
        println(rob(listOf(1, 2, 3, 1))) // Expected 4


        println(rob(listOf(2, 7, 9, 3, 1))) // Expected 12
    }

    private fun rob(nums: List<Int>): Int {
        val size = nums.size
        if (size == 0) return 0
        if (size == 1) return nums[0]
        if (size == 2) return max(nums[0], nums[1])

        // Create an array to store the maximum amount of money robbed up to each house.
        val cases = IntArray(size)

        // Base cases for the first two houses.
        cases[0] = nums[0]
        cases[1] = max(nums[0], nums[1])

        // Fill the array for the rest of the houses.
        for (i in 2 until size) {
            // The maximum amount of money we can rob up to the current house is either:
            // 1. The amount from robbing the current house + the amount from robbing the house two steps back.
            // 2. The amount from robbing the previous house (skipping the current house).
            cases[i] = max(nums[i] + cases[i - 2], cases[i - 1])
        }

        return cases.last()
    }
}
