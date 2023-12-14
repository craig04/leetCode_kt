package cn_solution

fun minInsertions(s: String): Int {
    val n = s.length
    val dp = Array(n) { IntArray(n) }
    for (i in n - 2 downTo 0)
        for (j in i + 1 until n)
            dp[i][j] = if (s[i] == s[j])
                dp[i + 1][j - 1]
            else
                minOf(dp[i + 1][j], dp[i][j - 1]) + 1
    return dp[0][n - 1]
}