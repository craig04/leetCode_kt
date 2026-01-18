package cn_solution

fun prefixConnected(words: Array<String>, k: Int): Int {
    return words.asSequence()
        .filter { it.length >= k }
        .groupingBy { it.take(k) }
        .eachCount()
        .count { it.value > 1 }
}