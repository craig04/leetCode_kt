package cn_solution

fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val m = nums2.size
    val dp = Array(n + 1) { IntArray(m + 1) { Int.MIN_VALUE } }
    for (i in 0 until n)
        for (j in 0 until m) {
            dp[i + 1][j + 1] = maxOf(
                dp[i][j + 1],
                dp[i + 1][j],
                maxOf(0, dp[i][j]) + nums1[i] * nums2[j]
            )
        }
    return dp[n][m]
}