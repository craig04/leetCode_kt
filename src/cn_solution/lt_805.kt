package cn_solution

fun splitArraySameAverage(nums: IntArray): Boolean {
    val n = nums.size
    val sum = nums.sum()
    val dp = Array(sum + 1) { BooleanArray(nums.size + 1) }
    dp[0][0] = true
    for (num in nums) {
        for (s in sum - num downTo 0)
            for (k in n - 1 downTo 0)
                dp[s + num][k + 1] = dp[s + num][k + 1] or dp[s][k]
    }
    return (1 until n).any { a ->
        val temp = sum * a
        temp % n == 0 && dp[temp / n][a]
    }
}