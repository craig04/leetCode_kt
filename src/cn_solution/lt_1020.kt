package cn_solution

fun numEnclaves(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val row = 0 until n
    val col = 0 until m
    val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    fun dfs(i: Int, j: Int) {
        if (grid[i][j] == 1) {
            grid[i][j] = 2
            dirs.forEach {
                val x = i + it.first
                val y = j + it.second
                if (x in row && y in col) dfs(x, y)
            }
        }
    }
    row.forEach {
        dfs(it, 0)
        dfs(it, m - 1)
    }
    col.forEach {
        dfs(0, it)
        dfs(n - 1, it)
    }
    return grid.sumBy { line -> line.count { it == 1 } }
}