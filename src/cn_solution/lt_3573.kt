package cn_solution

fun maximumProfit(prices: IntArray, k: Int): Long {
    val n = prices.size
    val dp = Array(k + 2) { LongArray(3) { Long.MIN_VALUE / 2 } }
    for (j in 1..k + 1)
        dp[j][0] = 0
    for (price in prices) {
        for (j in 1..k + 1) {
            dp[j][2] = maxOf(dp[j][2], dp[j][0] + price)
            dp[j][1] = maxOf(dp[j][1], dp[j][0] - price)
            dp[j][0] = maxOf(dp[j][0], dp[j - 1][1] + price, dp[j - 1][2] - price)
        }
    }
    return dp[k + 1][0]
}