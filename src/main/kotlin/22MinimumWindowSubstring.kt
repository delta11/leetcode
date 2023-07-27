/**
 * https://leetcode.com/problems/minimum-window-substring/?envType=list&envId=xi4ci4ig
 */
object MinimumWindowSubstring {
    @JvmStatic
    fun main(args: Array<String>) {
        println(minWindow("ADOBECODEBANC", "ABC"))

        println()

        println(minWindow("a", "a"))

        println()

        println(minWindow("a", "aa"))
    }

    fun minWindow(haystack: String, needle: String): String =
        (1..haystack.length)
            .flatMap {
                haystack.windowed(it, partialWindows = true)
            }
            .filter { window ->
                needle.toCharArray()
                    .all { it in window } &&
                        needle.length <= window.length
            }
            .minByOrNull { it.length } ?: ""
}
