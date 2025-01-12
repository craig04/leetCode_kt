package cn_solution

fun maximumAmount(coins: Array<IntArray>): Int {
    val n = coins.size
    val m = coins[0].size
    val dp = Array(3) { IntArray(m + 1) { Int.MIN_VALUE / 2 } }
    dp.forEach { it[1] = 0 }
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (k in 2 downTo 0) {
                dp[k][j + 1] = maxOf(dp[k][j + 1], dp[k][j]) + coins[i][j]
                if (k != 0)
                    dp[k][j + 1] = maxOf(dp[k][j + 1], dp[k - 1][j], dp[k - 1][j + 1])
            }
        }
    }
    return dp[2][m]
}