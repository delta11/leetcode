// From https://leetcode.com/problems/group-anagrams/

fun main() {
    println(groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat")))
// [["bat"],["nat","tan"],["ate","eat","tea"]]
    println(groupAnagrams(listOf("")))
// [[""]]
    println(groupAnagrams(listOf("a")))
// [["a"]]
}

fun groupAnagrams(texts: List<String>): List<List<String>> =
    texts
        .map { text ->
            texts
                .filter { textB -> areAnagrams(text, textB) }
                .sorted()
        }
        .distinct()


fun areAnagrams(textA: String, textB: String): Boolean = textA.toCharArray().sort() == textB.toCharArray().sort()
