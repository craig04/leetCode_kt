package cn_solution

fun lengthOfLIS(nums: IntArray): Int {
    var length = 0
    val dp = IntArray(nums.size + 1) { Int.MAX_VALUE }
    dp[0] = Int.MIN_VALUE
    for (n in nums) {
        var l = 1
        var r = length + 1
        while (l != r) {
            val m = (l + r) shr 1
            val mid = dp[m]
            when {
                mid >= n -> r = m
                else -> l = m + 1
            }
        }
        dp[l] = minOf(dp[l], n)
        length = maxOf(length, l)
    }
    return length
}
