package cn_solution

fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
    val dp = IntArray(target + 1) { Int.MIN_VALUE }
    dp[0] = 0
    for (num in nums)
        for (i in target downTo num)
            dp[i] = maxOf(dp[i], dp[i - num] + 1)
    return maxOf(-1, dp[target])
}