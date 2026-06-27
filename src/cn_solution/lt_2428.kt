package cn_solution

fun maxSum(grid: Array<IntArray>): Int {
    var ans = Int.MIN_VALUE
    for (i in 1 until grid.lastIndex)
        for (j in 1 until grid[i].lastIndex) {
            ans = maxOf(
                ans, grid[i][j] + grid[i - 1][j] + grid[i + 1][j]
                        + grid[i - 1][j - 1] + grid[i - 1][j + 1]
                        + grid[i + 1][j - 1] + grid[i + 1][j + 1]
            )
        }
    return ans
}