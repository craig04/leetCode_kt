package cn_solution

import java.util.*

private fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = moveTime.size
    val m = moveTime[0].size
    val dp = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val q = PriorityQueue<IntArray> { a, b -> a[2] - b[2] }
    dp[0][0] = 0
    q.offer(intArrayOf(0, 0, 0))
    while (dp[n - 1][m - 1] == Int.MAX_VALUE) {
        val (x, y, z) = q.poll()
        if (dp[x][y] != z)
            continue
        for (i in d.indices.step(2)) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u !in 0 until n || v !in 0 until m)
                continue
            val w = maxOf(moveTime[u][v], z) + 1 + (x + y).and(1)
            if (w < dp[u][v]) {
                dp[u][v] = w
                q.offer(intArrayOf(u, v, w))
            }
        }
    }
    return dp[n - 1][m - 1]
}