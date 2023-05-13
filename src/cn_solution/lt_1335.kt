package cn_solution

fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    if (n < d) {
        return -1
    }
    val dp = IntArray(n) { jobDifficulty[0] }
    for (j in 1 until n)
        dp[j] = maxOf(dp[j - 1], jobDifficulty[j])
    for (i in 1 until d) {
        for (j in n - d + i downTo i) {
            var temp = 0
            dp[j] = (j - 1 downTo i - 1).fold(Int.MAX_VALUE) { res, k ->
                temp = maxOf(temp, jobDifficulty[k + 1])
                minOf(res, dp[k] + temp)
            }
        }
    }
    return dp[n - 1]
}