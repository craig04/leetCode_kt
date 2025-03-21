package cn_solution

fun countPrefixes(words: Array<String>, s: String): Int {
    return words.count(s::startsWith)
}