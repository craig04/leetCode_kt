package cn_solution

fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
    val n = piles.size
    val dp = Array(n + 1) { IntArray(k + 1) { 0 } }
    piles.forEachIndexed { i, pile ->
        for (j in 0..k) {
            dp[i + 1][j] = dp[i][j]
            var w = 0
            for (t in 1..minOf(j, pile.size)) {
                w += pile[t - 1]
                dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j - t] + w)
            }
        }
    }
    return dp[n][k]
}