package cn_solution

fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
    val map = word.indices.step(k).groupingBy { word.substring(it, it + k) }.eachCountTo(HashMap())
    return map.entries.sumOf { it.value } - map.maxOf { it.value }
}