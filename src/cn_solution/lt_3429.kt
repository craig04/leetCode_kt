package cn_solution

fun minCost(n: Int, cost: Array<IntArray>): Long {
    val dp = Array(n / 2) { LongArray(9) { Long.MAX_VALUE } }
    for (j in 0 until 9)
        dp[0][j] = if (j / 3 == j % 3) Long.MAX_VALUE else cost[0][j / 3] + cost[n - 1][j % 3] + 0L
    for (i in 1 until dp.size) {
        for (j in 0 until 9) {
            val a = j / 3
            val b = j % 3
            if (a == b)
                continue
            for (k in 0 until 9) {
                val x = k / 3
                val y = k % 3
                if (x == y || x == a || y == b)
                    continue
                dp[i][j] = minOf(dp[i][j], dp[i - 1][k] + cost[i][a] + cost[n - i - 1][b])
            }
        }
    }
    return dp.last().min()
}