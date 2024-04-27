package cn_solution

fun hasValidPath(grid: Array<CharArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (n xor m and 1 == 0 || grid[0][0] == ')')
        return false
    val bound = (n + m - 1) shr 1
    val dp = Array(n) { Array(m) { IntArray(bound + 1) { -1 } } }
    dp[0][0][1] = 1
    fun dfs(x: Int, y: Int, k: Int): Int {
        if (dp[x][y][k] != -1) {
            return dp[x][y][k]
        }
        dp[x][y][k] = 0
        val t = k + if (grid[x][y] == '(') -1 else 1
        if (t !in 0..bound) {
            return 0
        }
        if ((x != 0 && dfs(x - 1, y, t) == 1) ||
            (y != 0 && dfs(x, y - 1, t) == 1)
        ) {
            dp[x][y][k] = 1
        }
        return dp[x][y][k]
    }
    return dfs(n - 1, m - 1, 0) == 1
}