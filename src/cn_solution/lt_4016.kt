package cn_solution

private fun maxArea(mat: Array<IntArray>): Int {
    fun maxLen(mat: Array<IntArray>): Int {
        val n = mat.size
        val m = mat.first().size
        val dp = Array(n + 1) { IntArray(m + 1) }
        val suf = IntArray(n + 1)
        for (i in n - 1 downTo 0)
            for (j in m - 1 downTo 0) {
                dp[i][j] = if (mat[i][j] == 0) 0 else 1 + minOf(
                    dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1]
                )
                suf[i] = maxOf(suf[i], dp[i][j])
            }
        dp.forEach { it.fill(0) }
        var pre = 0
        var ans = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                dp[i + 1][j + 1] = if (mat[i][j] == 0) 0 else 1 + minOf(
                    dp[i + 1][j], dp[i][j + 1], dp[i][j]
                )
                pre = maxOf(pre, dp[i + 1][j + 1])
            }
            ans = maxOf(ans, minOf(pre, suf[i + 1]))
        }
        return ans
    }

    val n = mat.size
    val m = mat.first().size
    val rot = Array(m) { IntArray(n) }
    for (i in 0 until m)
        for (j in 0 until n)
            rot[i][j] = mat[j][i]
    val len = maxOf(maxLen(mat), maxLen(rot))
    return len * len
}