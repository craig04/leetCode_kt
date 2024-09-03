package cn_solution

fun findLength(nums1: IntArray, nums2: IntArray): Int {
    val dp = IntArray(nums2.size + 1)
    var ans = 0
    for (i in nums1.indices) {
        for (j in nums2.indices.reversed()) {
            dp[j + 1] = if (nums1[i] == nums2[j]) dp[j] + 1 else 0
            ans = maxOf(ans, dp[j + 1])
        }
    }
    return ans
}