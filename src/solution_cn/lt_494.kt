package solution_cn

fun findTargetSumWays(nums: IntArray, target: Int): Int {
    val sum = nums.sum()
    val diff = sum - target
    if (Int.MIN_VALUE.or(1).and(diff) != 0) {
        return 0
    }
    val n = diff shr 1
    val dp = IntArray(n + 1)
    dp[0] = 1
    nums.forEach {
        for (j in n downTo it) {
            dp[j] += dp[j - it]
        }
    }
    return dp[n]
}