package cn_solution

fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
    val n = grid.size
    val m = grid[0].size
    val dp = Array(m + 1) { IntArray(k + 1) { Int.MIN_VALUE / 2 } }
    dp[1][0] = 0
    for (i in 0 until n)
        for (j in 0 until m) {
            val s = grid[i][j]
            val c = if (s == 0) 0 else 1
            for (t in minOf(k, i + j) downTo c)
                dp[j + 1][t] = maxOf(dp[j + 1][t - c], dp[j][t - c]) + s
            if (s != 0)
                dp[j + 1][0] = Int.MIN_VALUE / 2
        }
    return maxOf(dp[m].max(), -1)
}