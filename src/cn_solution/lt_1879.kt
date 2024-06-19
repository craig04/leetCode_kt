package cn_solution

fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val s = 1 shl n
    val dp = IntArray(s) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 1 until s) {
        val idx1 = i.countOneBits() - 1
        for (idx2 in 0 until n)
            if (1 shl idx2 and i != 0)
                dp[i] = minOf(dp[i], dp[1 shl idx2 xor i] + nums1[idx1].xor(nums2[idx2]))
    }
    return dp[s - 1]
}