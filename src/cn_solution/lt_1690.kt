package cn_solution

fun stoneGameVII(stones: IntArray): Int {
    val n = stones.size
    val s = IntArray(n + 1)
    for (i in stones.indices)
        s[i + 1] = s[i] + stones[i]
    val dp = IntArray(n)
    for (i in n - 2 downTo 0)
        for (j in i + 1 until n)
            dp[j] = maxOf(s[j + 1] - s[i + 1] - dp[j], s[j] - s[i] - dp[j - 1])
    return dp[n - 1]
}