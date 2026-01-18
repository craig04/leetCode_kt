package cn_solution

fun longestAlternating(nums: IntArray): Int {
    val n = nums.size
    val dp = Array(n) { Array(2) { IntArray(2) { 1 } } }
    return (1 until n).maxOf { i ->
        if (nums[i - 1] != nums[i]) {
            val inc = if (nums[i - 1] < nums[i]) 1 else 0
            dp[i][0][inc] = dp[i - 1][1][1 - inc] + 1
            dp[i][1][inc] = dp[i - 1][0][1 - inc] + 1
        }
        if (i > 2 && nums[i - 2] != nums[i]) {
            val inc = if (nums[i - 2] < nums[i]) 1 else 0
            dp[i][1][inc] = maxOf(dp[i][1][inc], dp[i - 2][0][1 - inc] + 1)
        }
        maxOf(dp[i][0][0], dp[i][0][1], dp[i][1][0], dp[i][1][1])
    }
}