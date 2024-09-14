package cn_solution

import kotlin.math.abs

fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array<IntArray> {
    val dist = Array(rows + cols) { ArrayList<IntArray>() }
    for (i in 0 until rows)
        for (j in 0 until cols)
            dist[abs(i - rCenter) + abs(j - cCenter)].add(intArrayOf(i, j))
    var i = 0
    var j = 0
    return Array(rows * cols) {
        val res = dist[i][j]
        if (++j == dist[i].size) {
            ++i
            j = 0
        }
        res
    }
}