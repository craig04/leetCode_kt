package cn_solution

fun canPartition(nums: IntArray): Boolean {
    var sum = nums.sum()
    if (sum and 1 == 1)
        return false
    sum /= 2
    val dp = BooleanArray(sum + 1)
    dp[0] = true
    return nums.any {
        for (i in sum downTo it)
            dp[i] = dp[i] or dp[i - it]
        dp[sum]
    }
}