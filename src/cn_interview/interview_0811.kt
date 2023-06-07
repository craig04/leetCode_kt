package cn_interview

fun waysToChange(n: Int): Int {
    val coin = intArrayOf(1, 5, 10, 25)
    val dp = IntArray(n + 1)
    dp[0] = 1
    for (c in coin)
        for (i in c..n)
            dp[i] = (dp[i] + dp[i - c]) % 1000000007
    return dp[n]
}