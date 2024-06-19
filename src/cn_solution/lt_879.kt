package cn_solution

fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
    val modulo = 1000000007
    val dp = Array(n + 1) { IntArray(minProfit + 1) }
    dp.forEach { it[0] = 1 }
    for (i in group.indices)
        for (j in n downTo 0)
            for (k in minProfit downTo 0) {
                if (group[i] <= j)
                    dp[j][k] += dp[j - group[i]][maxOf(0, k - profit[i])]
                dp[j][k] %= modulo
            }
    return dp[n][minProfit]
}