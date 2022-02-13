package cn_solution

fun strangePrinter(s: String): Int {
    val n = s.length
    val ca = s.toCharArray()
    val dp = Array(n) { IntArray(n) }
    for (i in n - 1 downTo 0) {
        dp[i][i] = 1
        for (j in i + 1 until n) {
            dp[i][j] = if (ca[i] == ca[j]) dp[i][j - 1] else {
                (i until j).fold(Int.MAX_VALUE) { res, k ->
                    res.coerceAtMost(dp[i][k] + dp[k + 1][j])
                }
            }
        }
    }
    return dp[0][n - 1]
}