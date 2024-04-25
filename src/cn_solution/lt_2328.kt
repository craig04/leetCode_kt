package cn_solution

fun countPaths(grid: Array<IntArray>): Int {
    val modulo = 1000000007
    val row = grid.indices
    val col = grid[0].indices
    val dp = Array(grid.size) { IntArray(grid[0].size) }
    fun dfs(i: Int, j: Int): Int {
        fun up(x: Int, y: Int) {
            val s = i + x
            val t = j + y
            if (s in row && t in col && grid[s][t] > grid[i][j])
                dp[i][j] = (dp[i][j] + dfs(s, t)) % modulo
        }
        if (dp[i][j] == 0) {
            dp[i][j] = 1
            up(-1, 0)
            up(0, -1)
            up(0, 1)
            up(1, 0)
        }
        return dp[i][j]
    }

    var result = 0L
    for (i in row)
        for (j in col)
            result += dfs(i, j)
    return (result % modulo).toInt()
}