package cn_solution

fun splitArray(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = Array(n + 1) { IntArray(k + 1) { Int.MAX_VALUE } }
    dp[0][0] = 0
    for (i in 1..n) {
        for (j in 1..minOf(k, i)) {
            var sum = 0
            dp[i][j] = (i - 1 downTo j - 1).minOf {
                sum += nums[it]
                maxOf(dp[it][j - 1], sum)
            }
        }
    }
    return dp[n][k]
}