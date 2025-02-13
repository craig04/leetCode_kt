package cn_solution

import java.util.*

fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
    val n = grid.size
    val a = Array(n) { 0 }
    for (t in 1 until 2 * n) {
        val i = maxOf(n - t, 0)
        val j = maxOf(t - n, 0)
        val len = n - maxOf(i, j)
        for (k in 0 until len)
            a[k] = grid[i + k][j + k]
        Arrays.sort(a, 0, len, if (t > n) null else Comparator.reverseOrder())
        for (k in 0 until len)
            grid[i + k][j + k] = a[k]
    }
    return grid
}