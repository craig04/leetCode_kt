package cn_solution

fun lenOfVDiagonal(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val row = grid.indices
    val col = grid[0].indices
    val dir = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, 1),
        intArrayOf(1, 1),
        intArrayOf(1, -1)
    )
    val dp = IntArray(n * m * 8) { -1 }
    fun dfs(x: Int, y: Int, i: Int, t: Int): Int {
        val key = ((x * m + y) * 4 + i) * 2 + t
        if (dp[key] == -1) {
            var ans = 0
            var u = x + dir[i][0]
            var v = y + dir[i][1]
            val w = grid[x][y] and 2 xor 2
            if (u in row && v in col && grid[u][v] == w)
                ans = dfs(u, v, i, t)
            if (t == 1 && grid[x][y] != 1) {
                val j = (i + 1) and 3
                u = x + dir[j][0]
                v = y + dir[j][1]
                if (u in row && v in col && grid[u][v] == w)
                    ans = maxOf(ans, dfs(u, v, j, 0))
            }
            dp[key] = ans + 1
        }
        return dp[key]
    }

    var ans = 0
    for (i in row)
        for (j in col)
            if (grid[i][j] == 1)
                for (k in dir.indices)
                    ans = maxOf(ans, dfs(i, j, k, 1))
    return ans
}