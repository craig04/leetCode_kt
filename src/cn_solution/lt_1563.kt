package cn_solution

fun stoneGameV(stoneValue: IntArray): Int {
    val n = stoneValue.size
    val pre = IntArray(n + 1)
    for (i in stoneValue.indices)
        pre[i + 1] = pre[i] + stoneValue[i]
    val dp = Array(n) { IntArray(n) }
    for (dist in 1 until n) {
        for (i in 0 until n - dist) {
            val j = i + dist
            dp[i][j] = (i until j).maxOf {
                val left = pre[it + 1] - pre[i]
                val right = pre[j + 1] - pre[it + 1]
                if (left < right) {
                    left + dp[i][it]
                } else if (left > right) {
                    right + dp[it + 1][j]
                } else {
                    left + maxOf(dp[i][it], dp[it + 1][j])
                }
            }
        }
    }
    return dp[0][n - 1]
}