package solution

fun countSquares(matrix: Array<IntArray>): Int {

    val row = matrix.size
    val col = matrix[0].size
    var count = 0
    val dp = Array(row + 1) { IntArray(col + 1) }
    for (i in 1..row) {
        for (j in 1..col) {
            dp[i][j] = if (matrix[i - 1][j - 1] == 0) 0 else
                1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
            count += dp[i][j]
        }
    }
    return count
}