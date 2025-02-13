package cn_solution

fun beautifulArray(n: Int): IntArray {
    val dp = Array(n + 1) { IntArray(it) }
    dp[1][0] = 1
    fun create(m: Int): IntArray {
        if (dp[m][0] == 0) {
            var i = 0
            for (x in create((m + 1) / 2))
                dp[m][i++] = 2 * x - 1
            for (y in create(m / 2))
                dp[m][i++] = 2 * y
        }
        return dp[m]
    }

    return create(n)
}