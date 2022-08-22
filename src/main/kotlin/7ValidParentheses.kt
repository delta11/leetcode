// From https://leetcode.com/problems/valid-parentheses/

fun main() {
    println(isValid("()")) // True
    println(isValid("()[]{}")) // True
    println(isValid("(]")) // False
    println(isValid("([)]")) // False
    println(isValid("{[]}")) // True
}

val opposites = mapOf(
    "(" to ")",
    "[" to "]",
    "{" to "}"
)

fun isValid(text: String): Boolean {
    for ((index, char) in text.withIndex()) {
        val remainingText = text.substring(index)
        val oppositeChar = opposites[char.toString()]
        return if (oppositeChar != null) {
            val indexOppositeChar = remainingText.indexOf(oppositeChar)
            if (indexOppositeChar == -1) false else {
                val textBetweenCurrentAndOppositeChar = remainingText.substring(1, indexOppositeChar)
                (textBetweenCurrentAndOppositeChar.none { char -> opposites.keys.contains(char.toString()) } &&
                        textBetweenCurrentAndOppositeChar.none { char -> opposites.values.contains(char.toString()) }) ||
                        (textBetweenCurrentAndOppositeChar.isNotEmpty() && isValid(textBetweenCurrentAndOppositeChar))
            }
        } else false
    }
    return true
}
