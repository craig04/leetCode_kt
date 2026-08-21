package cn_solution

private fun numberOfArithmeticSlices(nums: IntArray): Int {
    val dp = Array(nums.size) { HashMap<Long, Int>() }
    var ans = 0
    for (i in nums.indices)
        for (j in 0 until i) {
            val diff = 0L + nums[i] - nums[j]
            val cnt = dp[j][diff] ?: 0
            ans += cnt
            dp[i].merge(diff, cnt + 1, Int::plus)
        }
    return ans
}