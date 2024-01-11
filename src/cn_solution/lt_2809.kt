package cn_solution

fun minimumTime(nums1: List<Int>, nums2: List<Int>, x: Int): Int {
    val n = nums1.size
    val idx = Array(n) { it }
    idx.sortBy { nums2[it] }
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n)
        for (j in 1..i)
            dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - 1] + nums2[idx[i - 1]] * j + nums1[idx[i - 1]])
    val sum1 = nums1.sum()
    val sum2 = nums2.sum()
    return (0..n).firstOrNull { sum1 + sum2 * it - dp[n][it] <= x } ?: -1
}