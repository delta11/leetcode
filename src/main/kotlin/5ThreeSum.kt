// From https://leetcode.com/problems/3sum/

fun main() {
    println(threeSum(listOf(-1, 0, 1, 2, -1, -4))) // [[-1,-1,2],[-1,0,1]]
    println(threeSum(listOf())) // []
    println(threeSum(listOf(0))) // []
}

fun threeSum(nums: List<Int>): List<List<Any?>?> {
    if (nums.isEmpty() || nums.size < 3) {
        return listOf()
    }
    return nums
        .mapIndexed { index, num ->
            val usedKeysList = mutableListOf<Int>()
            nums.mapIndexed { index2, num2 ->
                if (index != index2)
                    nums.mapIndexed { index3, num3 ->
                        if (index != index3 && index2 != index3 && usedKeysList.none { it == index || it == index2 || it == index3 }) {
                            val triplet = listOf(num, num2, num3)
                            if(triplet.sum()==0) {
                                with(usedKeysList) {
                                    add(index)
                                    add(index2)
                                    add(index3)
                                }
                                triplet
                            } else null
                        } else null
                    }
                else null
            }
        }
        .flatMap { list -> list.filterNotNull() }
        .flatMap { list -> list.filterNotNull() }

}
