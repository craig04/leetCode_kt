package cn_solution

fun numIslands(grid: Array<CharArray>): Int {
    val n = grid.size - 1
    val m = grid[0].size - 1
    fun dfs(i: Int, j: Int): Boolean {
        if (grid[i][j] == '0')
            return false
        grid[i][j] = '0'
        if (i != 0) dfs(i - 1, j)
        if (i != n) dfs(i + 1, j)
        if (j != 0) dfs(i, j - 1)
        if (j != m) dfs(i, j + 1)
        return true
    }
    return (0..n).sumBy { i -> (0..m).count { j -> dfs(i, j) } }
}
