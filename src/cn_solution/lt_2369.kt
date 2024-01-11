package cn_solution

fun validPartition(nums: IntArray): Boolean {
    val dp = BooleanArray(nums.size + 1)
    dp[0] = true
    dp[2] = nums[0] == nums[1]
    for (i in 2 until nums.size) {
        if (nums[i] == nums[i - 1]) {
            dp[i + 1] = dp[i - 1] || (dp[i - 2] && nums[i] == nums[i - 2])
        } else if (nums[i] - nums[i - 1] == 1) {
            dp[i + 1] = dp[i - 2] && nums[i] - nums[i - 2] == 2
        }
    }
    return dp[nums.size]
}