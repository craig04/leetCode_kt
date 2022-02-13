package cn_solution

fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
    return words.filter { word ->
        val map = HashMap<Char, Int>()
        val rev = HashMap<Char, Int>()
        word.indices.all { map.put(word[it], it) == rev.put(pattern[it], it) }
    }
}