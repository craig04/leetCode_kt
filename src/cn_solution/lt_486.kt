package cn_solution

fun predictTheWinner(nums: IntArray): Boolean {
    val n = nums.size
    val dp = Array(n) { IntArray(n) }
    for (j in 0 until n) {
        dp[j][j] = nums[j]
        for (i in j - 1 downTo 0)
            dp[i][j] = maxOf(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
    }
    return dp[0][n - 1] >= 0
}