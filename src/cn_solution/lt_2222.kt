package cn_solution

private fun numberOfWays(s: String): Long {
    val dp = Array(4) { LongArray(2) }
    dp[0].fill(1)
    for (i in s.indices) {
        val c = s[i] - '0'
        dp[1][c] += dp[0][1 - c]
        dp[2][c] += dp[1][1 - c]
        dp[3][c] += dp[2][1 - c]
    }
    return dp[3].sum()
}