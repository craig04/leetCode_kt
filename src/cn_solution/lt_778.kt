package cn_solution

import java.util.*

fun swimInWater_bianrySearch(grid: Array<IntArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    var l = maxOf(grid[0][0], grid[n - 1][n - 1])
    var r = n * n - 1
    val bound = grid.indices
    val vis = Array(n) { IntArray(n) { -1 } }
    while (l != r) {
        val m = (l + r) / 2
        fun dfs(x: Int, y: Int): Boolean {
            if (x == n - 1 && y == n - 1)
                return true
            vis[x][y] = m
            for (i in d.indices.step(2)) {
                val u = x + d[i]
                val v = y + d[i + 1]
                if (u in bound && v in bound && grid[u][v] <= m && vis[u][v] != m && dfs(u, v))
                    return true
            }
            return false
        }
        if (dfs(0, 0))
            r = m
        else
            l = m + 1
    }
    return l
}

fun swimInWater_shortestPath(grid: Array<IntArray>): Int {
    val n = grid.size
    val range = 0 until n
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val q = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
    dp[0][0] = grid[0][0]
    q.offer(intArrayOf(grid[0][0], 0, 0))
    while (q.isNotEmpty()) {
        val (t, i, j) = q.poll()
        if (i == j && i == n - 1)
            break
        if (t > dp[i][j])
            continue
        for (k in d.indices step 2) {
            val x = i + d[k]
            val y = j + d[k + 1]
            if (x !in range || y !in range)
                continue
            val s = maxOf(t, grid[x][y])
            if (dp[x][y] > s) {
                dp[x][y] = s
                q.offer(intArrayOf(s, x, y))
            }
        }
    }
    return dp[n - 1][n - 1]
}