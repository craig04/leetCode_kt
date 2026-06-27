package cn_lcp

fun securityCheck(capacities: IntArray, k: Int): Int {
    val dp = IntArray(k + 1)
    dp[0] = 1
    for (c in capacities)
        for (i in k downTo c - 1)
            dp[i] = (dp[i] + dp[i - c + 1]) % 1000000007
    return dp[k]
}