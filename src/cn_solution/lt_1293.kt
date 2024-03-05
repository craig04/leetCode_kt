package cn_solution

fun shortestPath(grid: Array<IntArray>, k: Int): Int {
    val n = grid.size
    val m = grid[0].size
    if (k >= m + n - 3)
        return m + n - 2
    val row = grid.indices
    val col = grid[0].indices
    val dist = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val dp = Array(n) { Array(m) { IntArray(k + 1) { -1 } } }
    dp[0][0][0] = 0
    val q = ArrayDeque<IntArray>()
    q.addLast(intArrayOf(0, 0, 0))
    while (q.isNotEmpty()) {
        val (i, j, r) = q.removeFirst()
        if (i == n - 1 && j == m - 1)
            return dp[i][j][r]
        for (t in dist.indices step 2) {
            val x = i + dist[t]
            val y = j + dist[t + 1]
            if (x !in row || y !in col)
                continue
            if (grid[x][y] == 0 && dp[x][y][r] == -1) {
                dp[x][y][r] = dp[i][j][r] + 1
                q.addLast(intArrayOf(x, y, r))
            }
            if (grid[x][y] == 1 && r < k && dp[x][y][r + 1] == -1) {
                dp[x][y][r + 1] = dp[i][j][r] + 1
                q.addLast(intArrayOf(x, y, r + 1))
            }
        }
    }
    return -1
}