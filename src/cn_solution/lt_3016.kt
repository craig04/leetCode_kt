package cn_solution

private fun minimumPushes(word: String): Int {
    return word.groupingBy { it }
        .eachCount()
        .values
        .sortedDescending()
        .withIndex()
        .sumOf { (i, v) -> (1 + i / 8) * v }
}