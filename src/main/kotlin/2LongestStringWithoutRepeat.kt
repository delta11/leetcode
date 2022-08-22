// From https://leetcode.com/problems/longest-substring-without-repeating-characters/

fun main() {
    println(longestStringWithoutRepeatSimple("abcabcbb")) // 3
    println(longestStringWithoutRepeatSimple("bbbbb")) // 1
    println(longestStringWithoutRepeatSimple("pwwkew")) // 3
    println(longestStringWithoutRepeatSimple("")) // 0

    println()

    println(longestStringWithoutRepeatMyTrick("abcabcbb")) // 3
    println(longestStringWithoutRepeatMyTrick("bbbbb")) // 1
    println(longestStringWithoutRepeatMyTrick("pwwkew")) // 3
    println(longestStringWithoutRepeatMyTrick("")) // 0
}


fun longestStringWithoutRepeatSimple(string: String): Int {
    var max = 0
    for ((index, char) in string.withIndex()) {
        val charsFound = mutableSetOf(char)
        for ((innerIndex, innerChar) in string.withIndex()) {
            if (index != innerIndex) {
                if (char == innerChar || charsFound.contains(innerChar)) {
                    break
                }
                charsFound.add(innerChar)
            }
        }
        if (charsFound.size > max) {
            max = charsFound.size
        }
    }

    return max
}

fun longestStringWithoutRepeatMyTrick(string: String): Int {
    var result = setOf<Char>()
    string
        .fold(setOf<Char>()) { acc, char ->
            if (!acc.contains(char)) {
                setOf(*acc.toTypedArray(), char)
            } else {
                if(result.size< acc.size) {
                    result = acc
                }
                setOf(char)
            }
        }

    return result.size
}
