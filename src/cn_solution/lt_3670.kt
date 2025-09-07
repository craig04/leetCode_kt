package cn_solution

fun maxProduct(nums: IntArray): Long {
    val bits = 32 - nums.max().countLeadingZeroBits()
    val mask = 1.shl(bits) - 1
    val dp = IntArray(mask + 1)
    for (num in nums)
        dp[num] = num
    for (i in 1 until dp.size) {
        var j = i
        while (j != 0) {
            val low = j.takeLowestOneBit()
            dp[i] = maxOf(dp[i], dp[i xor low])
            j = j xor low
        }
    }
    return nums.maxOf { it * 1L * dp[it xor mask] }
}