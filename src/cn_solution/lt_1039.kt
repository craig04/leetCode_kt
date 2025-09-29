package cn_solution

fun minScoreTriangulation(v: IntArray): Int {
    val n = v.size
    val dp = Array(n) { IntArray(n) }
    for (i in n - 3 downTo 0)
        for (j in i + 2 until n) {
            dp[i][j] = Int.MAX_VALUE
            for (k in i + 1 until j)
                dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j] + v[i] * v[j] * v[k])
        }
    return dp[0][n - 1]
}