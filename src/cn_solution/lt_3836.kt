package cn_solution

private fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val n = nums1.size
    val m = nums2.size
    val dp = Array(k + 1) { Array(n + 1) { LongArray(m + 1) { Long.MIN_VALUE / 2 } } }
    dp[0].forEach { it.fill(0) }
    for (t in 1..k)
        for (i in 1..n)
            for (j in 1..m)
                dp[t][i][j] = maxOf(
                    dp[t][i - 1][j],
                    dp[t][i][j - 1],
                    dp[t - 1][i - 1][j - 1] + nums1[i - 1] * 1L * nums2[j - 1]
                )
    return dp[k][n][m]
}