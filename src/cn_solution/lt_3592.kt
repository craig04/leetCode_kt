package cn_solution

fun findCoins(numWays: IntArray): List<Int> {
    val n = numWays.size
    val dp = LongArray(n + 1)
    dp[0] = 1L
    val ans = ArrayList<Int>()
    for (i in 1..n) {
        when (numWays[i - 1] - dp[i]) {
            0L -> continue
            1L -> {
                for (j in 0..n - i)
                    dp[j + i] += dp[j]
                ans.add(i)
            }
            else -> return emptyList()
        }
    }
    return ans
}