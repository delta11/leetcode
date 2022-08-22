// From https://leetcode.com/problems/jump-game/

fun main() {
    println(canJump(listOf(2,3,1,1,4)))
// True
    println(canJump(listOf(3,2,1,0,4)))
// False
}

fun canJump(numbers: List<Int>): Boolean {
    if(numbers.isEmpty()) {
        return false
    }

    val currentValue = numbers[0]
    if(currentValue==0) {
        return false
    }
    for (index in 1..currentValue) {
        if(index == numbers.size) {
            return true
        }
    }

    return canJump(numbers.subList(1, numbers.size))
}


