package cn_solution

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val n = matrix.size
    if (n == 1)
        return matrix[0][0]
    val dp = IntArray(n)
    for (row in matrix) {
        var last = dp[0]
        dp[0] = minOf(dp[0], dp[1]) + row[0]
        for (i in 1 until n - 1) {
            val temp = dp[i]
            dp[i] = minOf(last, dp[i], dp[i + 1]) + row[i]
            last = temp
        }
        dp[n - 1] = minOf(dp[n - 1], last) + row[n - 1]
    }
    return dp.min()!!
}