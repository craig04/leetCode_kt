package cn_solution

fun closeStrings(word1: String, word2: String): Boolean {
    val freq1 = word1.groupingBy { it }.eachCount()
    val freq2 = word2.groupingBy { it }.eachCount()
    return freq1.keys == freq2.keys && freq1.values.sorted() == freq2.values.sorted()
}