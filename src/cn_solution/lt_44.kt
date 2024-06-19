package cn_solution

fun isMatch(s: String, p: String): Boolean {
    val n = s.length
    val m = p.length
    val dp = Array(n + 1) { BooleanArray(m + 1) }
    for (i in p.indices.reversed()) {
        if (p[i] != '*')
            break
        dp[n][i] = true
    }
    dp[n][m] = true
    for (i in n - 1 downTo 0)
        for (j in m - 1 downTo 0) {
            dp[i][j] = if (p[j] == '*')
                (i..n).any { dp[it][j + 1] }
            else
                dp[i + 1][j + 1] && (s[i] == p[j] || p[j] == '?')
        }
    return dp[0][0]
}