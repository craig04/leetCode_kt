package cn_solution

private fun maxProduct(nums: IntArray): Long {
    val bits = 32 - nums.max().countLeadingZeroBits()
    val mask = 1.shl(bits) - 1
    val dp = IntArray(mask + 1)
    for (num in nums)
        dp[num] = num
    for (i in 0 until bits)
        for (j in 0..mask)
            dp[j] = maxOf(dp[j], dp[1.shl(i).inv().and(j)])
    return nums.maxOf { it * 1L * dp[it xor mask] }
}