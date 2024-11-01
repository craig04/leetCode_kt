package cn_solution

fun maxScore(a: IntArray, b: IntArray): Long {
    val n = a.size
    val m = b.size
    val dp = Array(m + 1) { LongArray(n + 1) { -(1L shl 50) } }
    for (i in b.indices) {
        dp[i][0] = 0
        val bi = b[i].toLong()
        for (j in a.indices)
            dp[i + 1][j + 1] = maxOf(dp[i][j + 1], dp[i][j] + bi * a[j])
    }
    return dp[m][n]
}