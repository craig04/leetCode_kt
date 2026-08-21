package cn_solution

fun minCost(grid: Array<IntArray>, k: Int): Int {
    val dir = intArrayOf(1, 0, 0, 1, -1, 0, 0, -1)
    val n = grid.size
    val m = grid.first().size
    val dp = Array(n) { Array(m) { Array(k + 1) { IntArray(4) { -1 } } } }
    fun dfs(x: Int, y: Int, z: Int, i: Int): Int {
        if (x == n - 1 && y == m - 1)
            return grid[x][y]
        var res = dp[x][y][z][i]
        if (res != -1)
            return res
        res = Int.MAX_VALUE / 2
        for (t in dir.indices.step(2)) {
            val j = t / 2
            val u = x + dir[t]
            val v = y + dir[t + 1]
            val w = if (i == j) z else z + 1
            if (u in 0 until n && v in 0 until m && w <= k)
                res = minOf(res, grid[x][y] + dfs(u, v, w, j))
        }
        dp[x][y][z][i] = res
        return res
    }

    val res = minOf(dfs(0, 0, 0, 0), dfs(0, 0, 0, 1))
    return if (res == Int.MAX_VALUE / 2) -1 else res
}