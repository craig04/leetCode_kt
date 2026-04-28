package cn_solution

fun maximumJumps(nums: IntArray, target: Int): Int {
    val n = nums.size
    val dp = IntArray(n)
    dp[0] = 0
    for (i in 1 until n) {
        dp[i] = Int.MIN_VALUE
        for (j in 0 until i)
            if (nums[i] - nums[j] in -target..target)
                dp[i] = maxOf(dp[i], dp[j] + 1)
    }
    return maxOf(dp[n - 1], -1)
}