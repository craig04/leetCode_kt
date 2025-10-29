package cn_solution

fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (s in strs) {
        val x = s.count { it == '0' }
        val y = s.length - x
        for (i in m downTo x)
            for (j in n downTo y)
                dp[i][j] = maxOf(dp[i][j], dp[i - x][j - y] + 1)
    }
    return dp.maxOf { it.max() }
}