package cn_solution

private fun minCost(m: Int, n: Int, penalty: Array<IntArray>): Long {
    data class Step(val cost: Long, val x: Int, val y: Int, val p: Int)

    val dir = intArrayOf(0, -1, -1, 0, 0, 1, 1, 0, 0, 0)
    val dp = Array(2) { Array(m) { LongArray(n) { Long.MAX_VALUE } } }
    dp[1][0][0] = 1
    val pq = java.util.PriorityQueue<Step> { (a), (b) -> a.compareTo(b) }
    pq.offer(Step(1, 1, 0, 0))
    while (pq.isNotEmpty()) {
        val (curr, p, x, y) = pq.poll()
        if (curr > dp[p][x][y])
            continue
        for (t in dir.indices.step(2)) {
            val u = x + dir[t]
            val v = y + dir[t + 1]
            if (u !in 0 until m || v !in 0 until n)
                continue
            var next = curr
            if (u != x || v != y)
                next += (u + 1L) * (v + 1L)
            if (t / 4 != p)
                next += penalty[x][y]
            if (next < dp[1 - p][u][v]) {
                dp[1 - p][u][v] = next
                pq.offer(Step(next, 1 - p, u, v))
            }
        }
    }
    return dp.minOf { it[m - 1][n - 1] }
}