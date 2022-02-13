package cn_solution

fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1) { it }
    for (i in 1..n) {
        val s = i * i
        if (s > n) {
            break
        }
        for (j in s..n) {
            dp[j] = dp[j].coerceAtMost(dp[j - s] + 1)
        }
    }
    return dp[n]
}