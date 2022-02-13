package cn_solution

/**
 * TODO: TO BE UPDATE
 */
fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
    val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
    for (i in nums1.indices) {
        for (j in nums2.indices) {
            dp[i + 1][j + 1] = if (nums1[i] == nums2[j]) {
                dp[i][j] + 1
            } else {
                maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }
    return dp[nums1.size][nums2.size]
}