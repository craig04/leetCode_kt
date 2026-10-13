package cn_solution

fun closedIsland(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid.first().size
    val row = grid.indices
    val col = grid.first().indices
    val vis = Array(n) { BooleanArray(m) }
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    fun dfs(i: Int, j: Int): Boolean {
        vis[i][j] = true
        var res = i != 0 && i != n - 1 && j != 0 && j != m - 1
        for (t in dir.indices.step(2)) {
            val x = i + dir[t]
            val y = j + dir[t + 1]
            if (x in row && y in col && grid[x][y] == 0 && !vis[x][y])
                res = res and dfs(x, y)
        }
        return res
    }
    return row.sumOf { i ->
        col.count { j ->
            grid[i][j] == 0 && !vis[i][j] && dfs(i, j)
        }
    }
}