package solution_cn

fun maxValue(grid: Array<IntArray>): Int {
    val row = grid.size
    val col = grid.first().size
    val dp = Array(row + 1) { IntArray(col + 1) }
    for (i in 1..row) {
        for (j in 1..col) {
            dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]
        }
    }
    return dp[row][col]
}