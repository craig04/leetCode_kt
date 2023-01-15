package cn_solution

fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val map = HashMap<Int, Int>()
    fun Array<IntArray>.fill() = forEach { (v, w) -> map[v] = (map[v] ?: 0) + w }
    items1.fill()
    items2.fill()
    return map.asSequence().sortedBy { it.key }.map { listOf(it.key, it.value) }.toList()
}