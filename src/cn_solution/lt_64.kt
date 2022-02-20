package cn_solution

fun minPathSum(grid: Array<IntArray>): Int {
    for (j in 1 until grid[0].size) {
        grid[0][j] += grid[0][j - 1]
    }
    for (i in 1 until grid.size) {
        grid[i][0] += grid[i - 1][0]
        for (j in 1 until grid[0].size) {
            grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
        }
    }
    return grid.last().last()
}