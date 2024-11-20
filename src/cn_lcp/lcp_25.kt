package cn_lcp

fun keyboard(k: Int, n: Int): Int {
    val modulo = 1000000007
    val c = Array(n + 1) { LongArray(k + 1) }
    for (i in 0..n) {
        c[i][0] = 1
        for (j in 1..minOf(i, k))
            c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % modulo
    }
    val dp = Array(27) { LongArray(n + 1) }
    for (i in 0..26) {
        dp[i][0] = 1
        for (j in 1..minOf(i * k, n))
            for (t in 0..minOf(j, k))
                dp[i][j] = (dp[i][j] + dp[i - 1][j - t] * c[j][t]) % modulo
    }
    return dp[26][n].mod(modulo)
}