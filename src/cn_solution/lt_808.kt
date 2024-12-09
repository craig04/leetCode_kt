package cn_solution

fun soupServings(n: Int): Double {
    if (n >= 5000)
        return 1.0
    val dp = Array(200) { DoubleArray(200) { -1.0 } }
    for (x in dp.indices) {
        dp[0][x] = 1.0
        dp[x][0] = 0.0
    }
    dp[0][0] = 0.5
    fun dfs(a: Int, b: Int): Double {
        val c = maxOf(0, a)
        val d = maxOf(0, b)
        if (dp[c][d] == -1.0) {
            dp[c][d] = (dfs(c - 4, d) + dfs(c - 3, d - 1)
                    + dfs(c - 2, d - 2) + dfs(c - 1, d - 3)) / 4
        }
        return dp[c][d]
    }

    val m = (n + 24) / 25
    return dfs(m, m)
}