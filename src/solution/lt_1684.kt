package solution

fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    val dict = allowed.toHashSet()
    return words.count { word -> word.all { it in allowed } }
}