package cn_solution

fun maxCoins(nums: IntArray): Int {
    val n = nums.size
    val a = IntArray(n + 2)
    a[0] = 1
    a[n + 1] = 1
    nums.copyInto(a, 1)
    val dp = Array(n + 2) { IntArray(n + 2) }
    for (j in 2..n + 1)
        for (i in j - 2 downTo 0)
            for (k in i + 1 until j)
                dp[i][j] = maxOf(dp[i][j], dp[i][k] + dp[k][j] + a[k] * a[i] * a[j])
    return dp[0][n + 1]
}