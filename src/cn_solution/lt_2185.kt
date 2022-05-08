package cn_solution

fun prefixCount(words: Array<String>, pref: String): Int {
    return words.count { it.startsWith(pref) }
}