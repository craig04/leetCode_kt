package cn_solution

private fun minimumPushes(word: String): Int {
    return word.groupingBy { it }
        .eachCount()
        .values
        .sortedDescending()
        .withIndex()
        .sumOf { (it.index / 8 + 1) * it.value }
}
