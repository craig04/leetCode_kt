package cn_solution

fun heightChecker(heights: IntArray): Int {
    val sorted = heights.sortedArray()
    return heights.indices.count { sorted[it] != heights[it] }
}