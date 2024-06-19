package cn_solution

fun paintWalls(cost: IntArray, time: IntArray): Int {
    val n = cost.size
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 0 until n)
        for (j in n - 1 downTo 0)
            if (dp[j] != Int.MAX_VALUE) {
                val k = minOf(n, j + 1 + time[i])
                dp[k] = minOf(dp[k], dp[j] + cost[i])
            }
    return dp[n]
}