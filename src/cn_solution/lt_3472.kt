package cn_solution

import kotlin.math.abs

fun longestPalindromicSubsequence(s: String, k: Int): Int {
    val n = s.length
    val dp = Array(n) { Array(n + 1) { IntArray(k + 1) } }
    for (i in s.indices) {
        dp[i][i].fill(1)
        dp[i][i + 1].fill(1)
    }
    for (len in 2..n) {
        for (i in 0 until n - len + 1) {
            val j = i + len
            var dist = abs(s[i] - s[j - 1])
            dist = minOf(dist, 26 - dist)
            for (t in 0..k) {
                dp[i][j][t] = maxOf(dp[i + 1][j][t], dp[i][j - 1][t])
                if (t >= dist)
                    dp[i][j][t] = maxOf(dp[i][j][t], dp[i + 1][j - 1][t - dist] + 2)
            }
        }
    }
    return dp[0][n][k]
}