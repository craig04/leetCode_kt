package cn_solution

import kotlin.math.abs

fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
    val n = grid.size
    val m = grid[0].size
    val ans = Array(n) { IntArray(m) }
    for (k in 1 - m..n) {
        var i = maxOf(0, k)
        var j = maxOf(0, -k)
        var bits = 0L
        while (i < n && j < m) {
            ans[i][j] = bits.countOneBits()
            bits = 1L shl grid[i++][j++] or bits
        }
        bits = 0
        while (--i >= 0 && --j >= 0) {
            ans[i][j] = abs(ans[i][j] - bits.countOneBits())
            bits = 1L shl grid[i][j] or bits
        }
    }
    return ans
}