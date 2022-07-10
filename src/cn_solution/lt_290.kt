package cn_solution

fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(' ')
    val map = HashMap<Any, Int>()
    return words.size == pattern.length && words.indices.all {
        map.put(words[it], it) == map.put(pattern[it], it)
    }
}