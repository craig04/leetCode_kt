package cn_solution

fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
    return words.asSequence().flatMap { it.split(separator) }.filter { it.isNotEmpty() }.toList()
}