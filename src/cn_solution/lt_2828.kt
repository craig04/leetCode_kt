package cn_solution

fun isAcronym(words: List<String>, s: String): Boolean {
    return words.size == s.length && s.indices.all { s[it] == words[it][0] }
}