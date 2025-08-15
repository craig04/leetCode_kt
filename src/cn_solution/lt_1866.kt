package cn_solution

fun rearrangeSticks(n: Int, k: Int): Int {
    val modulo = 1000000007
    val dp = IntArray(k + 1)
    dp[1] = 1
    for (i in 2..n)
        for (j in minOf(i, k) downTo 1)
            dp[j] = (dp[j] * (i - 1L) + dp[j - 1]).mod(modulo)
    return dp[k]
}