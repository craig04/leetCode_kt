package cn_lcr

fun coinChange(coins: IntArray, amount: Int): Int {
    val max = Int.MAX_VALUE - 1
    val dp = IntArray(amount + 1) { max }
    dp[0] = 0
    for (c in coins)
        for (i in c..amount)
            dp[i] = minOf(dp[i], dp[i - c] + 1)
    return if (dp[amount] == max) -1 else dp[amount]
}