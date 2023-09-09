package cn_solution

import kotlin.math.abs

fun checkValidGrid(grid: Array<IntArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    val x = IntArray(n * m)
    val y = IntArray(n * m)
    for (i in grid.indices)
        for (j in grid[0].indices) {
            x[grid[i][j]] = i
            y[grid[i][j]] = j
        }
    return x[0] + y[0] == 0 && (1 until x.size).all { i ->
        abs(x[i] - x[i - 1]) * abs(y[i] - y[i - 1]) == 2
    }
}