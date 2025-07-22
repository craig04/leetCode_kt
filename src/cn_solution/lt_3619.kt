package cn_solution

fun countIslands(grid: Array<IntArray>, k: Int): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid[0].size
    val vis = Array(n) { BooleanArray(m) }
    fun dfs(i: Int, j: Int): Long {
        vis[i][j] = true
        var res = 0L + grid[i][j]
        for (t in d.indices.step(2)) {
            val x = i + d[t]
            val y = j + d[t + 1]
            if (x in 0 until n && y in 0 until m && grid[x][y] != 0 && !vis[x][y])
                res += dfs(x, y)
        }
        return res
    }
    return (0 until n).sumOf { i ->
        (0 until m).count { j ->
            grid[i][j] != 0 && !vis[i][j] && dfs(i, j) % k == 0L
        }
    }
}