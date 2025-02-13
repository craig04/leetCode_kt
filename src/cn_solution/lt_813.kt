package cn_solution

fun largestSumOfAverages(nums: IntArray, k: Int): Double {
    val n = nums.size
    val pre = DoubleArray(n + 1)
    nums.forEachIndexed { i, num -> pre[i + 1] = pre[i] + num }
    val dp = Array(n + 1) { DoubleArray(k + 1) }
    for (i in 1..n) {
        for (j in 1..minOf(i, k)) {
            dp[i][j] = if (j == 1) {
                pre[i] / i
            } else (j - 1 until i).maxOf { t ->
                dp[t][j - 1] + (pre[i] - pre[t]) / (i - t)
            }
        }
    }
    return dp[n][k]
}