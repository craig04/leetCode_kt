package cn_solution

private fun minFlips(grid: Array<IntArray>): Int {
    var row = 0
    var col = 0
    val n = grid.size
    val m = grid[0].size
    for (i in 0 until n)
        for (j in 0 until m) {
            if (grid[i][j] != grid[i][m - j - 1])
                row++
            if (grid[i][j] != grid[n - i - 1][j])
                col++
        }
    return minOf(row, col) / 2
}