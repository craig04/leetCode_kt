package cn_solution

fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
    val mod = 1000000007
    val dp = IntArray(n + 1)
    dp[1] = 1
    for (i in 2..n) {
        val s = maxOf(0, i - forget)
        val e = maxOf(0, i - delay)
        val new = (dp[e] - dp[s] + mod) % mod
        dp[i] = (new + dp[i - 1]) % mod
    }
    return (dp[n] - dp[n - forget] + mod) % mod
}