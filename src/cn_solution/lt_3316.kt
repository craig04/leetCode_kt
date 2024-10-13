package cn_solution

fun maxRemovals(source: String, pattern: String, targetIndices: IntArray): Int {
    val n = source.length
    val m = pattern.length
    val s = source.toCharArray()
    val p = pattern.toCharArray()
    val set = IntArray(n + 1)
    targetIndices.forEach { set[it + 1] = 1 }
    val dp = Array(n + 1) { IntArray(m + 1) { Int.MIN_VALUE } }
    dp[0][0] = 0
    for (i in 1..n)
        for (j in 0..minOf(i, m)) {
            dp[i][j] = dp[i - 1][j] + set[i]
            if (j != 0 && s[i - 1] == p[j - 1])
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - 1])
        }
    return dp[n][m]
}