package cn_solution

import kotlin.math.abs

fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
    val n = grid.size
    val m = grid[0].size
    val vis = Array(n) { BooleanArray(m) }
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    fun dfs(x: Int, y: Int) {
        vis[x][y] = true
        var border = false
        for (i in dir.indices.step(2)) {
            val u = x + dir[i]
            val v = y + dir[i + 1]
            if (u !in 0 until n || v !in 0 until m || abs(grid[u][v]) != abs(grid[x][y])) {
                border = true
                continue
            }
            if (!vis[u][v])
                dfs(u, v)
        }
        if (border)
            grid[x][y] = -grid[x][y]
    }
    dfs(row, col)
    for (i in 0 until n)
        for (j in 0 until m)
            if (grid[i][j] < 0)
                grid[i][j] = color
    return grid
}