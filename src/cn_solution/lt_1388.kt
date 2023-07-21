package cn_solution

fun maxSizeSlices(slices: IntArray): Int {
    val n = slices.size / 3
    fun solve(l: Int, r: Int): Int {
        val dp = Array(r - l + 1) { IntArray(n + 1) }
        dp[0][1] = slices[l]
        dp[1][1] = maxOf(slices[l], slices[l + 1])
        for (i in 2..(r - l))
            for (j in 1..minOf(n, (i + 2) shr 1)) {
                dp[i][j] = maxOf(dp[i - 2][j - 1] + slices[i + l], dp[i - 1][j])
            }
        return dp[r - l][n]
    }
    return maxOf(solve(0, slices.lastIndex - 1), solve(1, slices.lastIndex))
}