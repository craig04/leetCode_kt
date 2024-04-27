package cn_solution

import java.util.*

fun swimInWater(grid: Array<IntArray>): Int {
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