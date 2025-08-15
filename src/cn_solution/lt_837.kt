package cn_solution

fun new21Game(n: Int, k: Int, maxPts: Int): Double {
    if (k == 0 || n >= k - 1 + maxPts)
        return 1.0
    val dp = DoubleArray(k + maxPts)
    dp.fill(1.0, k, n + 1)
    dp[k - 1] = (n - k + 1.0) / maxPts
    for (i in k - 2 downTo 0)
        dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + maxPts + 1]) / maxPts
    return dp[0]
}