package solution_cn

fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (s in strs) {
        val zero = s.count { it == '0' }
        val one = s.length - zero
        for (i in m downTo zero)
            for (j in n downTo one)
                if (dp[i - zero][j - one] != Int.MAX_VALUE)
                    dp[i][j] = dp[i][j].coerceAtLeast(dp[i - zero][j - one] + 1)
    }
    var result = 0
    for (i in dp)
        for (j in i)
            result = result.coerceAtLeast(j)
    return result
}