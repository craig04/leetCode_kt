package cn_solution

fun getMoneyAmount(n: Int): Int {
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (l in n - 1 downTo 1)
        for (r in l + 1..n) {
            dp[l][r] = minOf((l until r).minOf { m ->
                maxOf(dp[l][m - 1], dp[m + 1][r]) + m
            }, dp[l][r - 1] + r)
        }
    return dp[1][n]
}