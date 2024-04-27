package cn_solution

private fun maxScore(nums: IntArray, x: Int): Long {
    val dp = LongArray(2) { 0 }
    for (i in nums.indices.reversed()) {
        val t = nums[i] and 1
        dp[t] = nums[i] + maxOf(0, dp[t], dp[t xor 1] - x)
    }
    return dp[nums[0] and 1]
}