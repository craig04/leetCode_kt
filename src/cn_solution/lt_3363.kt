package cn_solution

fun maxCollectedFruits(fruits: Array<IntArray>): Int {
    val n = fruits.size
    fun solve(): Int {
        val dp = Array(n) { IntArray(n) }
        dp[0][n - 1] = fruits[0][n - 1]
        for (i in 1 until n - 1) {
            val pre = dp[i - 1]
            var j = if (i < n / 2) n - 1 - i else i + 1
            while (j < n - 1)
                dp[i][j] = maxOf(pre[j - 1], pre[j], pre[j + 1]) + fruits[i][j++]
            dp[i][n - 1] = maxOf(pre[n - 2], pre[n - 1]) + fruits[i][n - 1]
        }
        return dp[n - 2][n - 1]
    }

    val ans = fruits.indices.sumOf { fruits[it][it] } + solve()
    for (i in 0 until n)
        for (j in i + 1 until n)
            fruits[i][j] = fruits[j][i]
    return ans + solve()
}