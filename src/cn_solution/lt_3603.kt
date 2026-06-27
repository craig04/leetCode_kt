package cn_solution

private fun minCost(m: Int, n: Int, waitCost: Array<IntArray>): Long {
    val dp = Array(m + 1) { LongArray(n + 1) { Long.MAX_VALUE / 2 } }
    dp[0][1] = 0L - waitCost[0][0]
    for (i in 1..m)
        for (j in 1..n)
            dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + waitCost[i - 1][j - 1] + 1L * i * j
    return dp[m][n] - waitCost[m - 1][n - 1]
}