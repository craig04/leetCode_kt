package cn_solution

import kotlin.math.abs

fun maxConsistentColumns(grid: Array<IntArray>, limit: Int): Int {
    val n = grid.size
    val m = grid.first().size
    val dp = IntArray(m) { 1 }
    for (i in 0 until m)
        loop@ for (j in 0 until i)
            if (dp[j] + 1 > dp[i]) {
                for (k in 0 until n)
                    if (abs(grid[k][i] - grid[k][j]) > limit)
                        continue@loop
                dp[i] = dp[j] + 1
            }
    return dp.max()
}