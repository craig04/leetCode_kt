package cn_solution

fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    return words.indices.filter { words[it].contains(x) }
}