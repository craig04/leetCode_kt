package cn_solution

private fun maximumScore(nums: IntArray, k: Int): Long {
    val n = nums.size
    val pos = nums.indices.maxBy { nums[it] }
    fun solve(indices: IntProgression): Long {
        val dp = Array(k + 2) { LongArray(3) { Long.MIN_VALUE / 2 } }
        for (i in 1..k + 1)
            dp[i][0] = 0
        for (t in indices) {
            val s = nums[t % n]
            for (i in 1..k + 1) {
                dp[i][2] = maxOf(dp[i][2], dp[i][0] + s)
                dp[i][1] = maxOf(dp[i][1], dp[i][0] - s)
                dp[i][0] = maxOf(dp[i][0], dp[i - 1][1] + s, dp[i - 1][2] - s)
            }
        }
        return dp[k + 1][0]
    }
    return maxOf(
        solve(pos until pos + n),
        solve(pos + 1..pos + n)
    )
}