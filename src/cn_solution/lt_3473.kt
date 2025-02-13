package cn_solution

fun maxSum(nums: IntArray, k: Int, m: Int): Int {
    val n = nums.size
    val pre = IntArray(n + 1)
    val dp = IntArray(n + 1)
    val help = IntArray(n + 1)
    for (i in 0 until n)
        pre[i + 1] = pre[i] + nums[i]
    for (t in 1..k) {
        for (i in 1..n)
            help[i] = maxOf(help[i - 1], dp[i] - pre[i])
        for (i in 0 until t * m)
            dp[i] = Int.MIN_VALUE / 2
        for (i in t * m..n)
            dp[i] = maxOf(dp[i - 1], pre[i] + help[i - m])
    }
    return dp[n]
}