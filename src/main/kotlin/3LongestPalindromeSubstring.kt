// From https://leetcode.com/problems/longest-palindromic-substring/solution/

fun main() {
    println(longestStringPalindromeSubString("babad")) // bab
    println(longestStringPalindromeSubString("cbbd")) // bb
    println(longestStringPalindromeSubString("a")) // a
    println(longestStringPalindromeSubString("ac")) // a
}

/**
 * A lot of brute force to get all the sliding windows, but it does feel quite Kotlin idiomatic.
 */
fun longestStringPalindromeSubString(string: String): String =
    IntRange(1, string.length)
        .flatMap { size ->
            string.windowed(size, partialWindows = true)
                .filter { stringWindow -> stringWindow.reversed() == stringWindow }
        }
        .maxOfWith(Comparator.comparing(String::length)) { it }
