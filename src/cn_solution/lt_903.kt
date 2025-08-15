package cn_solution

fun numPermsDISequence(s: String): Int {
    val modulo = 1000000007
    val n = s.length
    val dp = Array(n + 1) { IntArray(n + 2) }
    dp[n].fill(1, 1, n + 2)
    for (i in n - 1 downTo 0) {
        for (j in 1..n + 1 - i)
            if (s[i] == 'I')
                dp[i][j] = (dp[i + 1][n - i] - dp[i + 1][j - 1] + modulo) % modulo
            else
                dp[i][j] = dp[i + 1][j - 1]
        for (j in 1 until n + 2)
            dp[i][j] = (dp[i][j] + dp[i][j - 1]) % modulo
    }
    return dp[0][n + 1]
}