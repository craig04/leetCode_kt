package cn_solution

fun numOfArrays(n: Int, m: Int, k: Int): Int {
    val modulo = 1000000007
    val dp = Array(k + 1) { LongArray(m + 1) }
    dp[0][0] = 1
    for (r in 0 until n) {
        for (i in k downTo 1) {
            var sum = dp[i - 1].sum()
            for (j in m downTo 1) {
                sum -= dp[i - 1][j]
                dp[i][j] = (dp[i][j] * j + sum) % modulo
            }
        }
        dp[0][0] = 0
    }
    return dp[k].sum().rem(modulo).toInt()
}