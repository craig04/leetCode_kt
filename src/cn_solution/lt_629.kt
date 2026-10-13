package cn_solution

fun kInversePairs(n: Int, k: Int): Int {
    val modulo = 1000000007
    val dp = Array(2) { LongArray(k + 1) }
    dp[0][0] = 1
    for (i in 1..n) {
        val cur = i and 1
        val pre = 1 - cur
        for (j in 0..k) {
            dp[cur][j] = dp[pre][j]
            if (j != 0)
                dp[cur][j] += dp[cur][j - 1]
            if (j >= i)
                dp[cur][j] -= dp[pre][j - i]
            dp[cur][j] %= modulo
        }
    }
    return (dp[n and 1][k] + modulo).mod(modulo)
}