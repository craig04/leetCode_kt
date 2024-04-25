package cn_solution

private fun cherryPickup(grid: Array<IntArray>): Int {
    val n = grid.size
    var pre = Array(n) { IntArray(n) }
    var cur = Array(n) { IntArray(n) }
    val dir = intArrayOf(-1, 0)
    pre[0][0] = grid[0][0]
    for (k in 1 until 2 * n - 1) {
        val range = 0 until k
        for (x1 in maxOf(0, k - n + 1)..minOf(k, n - 1)) {
            val y1 = k - x1
            for (x2 in maxOf(0, k - n + 1)..x1) {
                val y2 = k - x2
                cur[x1][x2] = -1
                if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                    continue
                }
                var tmp = -1
                for (dx1 in dir)
                    for (dx2 in dir) {
                        val u1 = x1 + dx1
                        val u2 = x2 + dx2
                        if (u1 < u2 || u1 !in range || u2 !in range)
                            continue
                        tmp = maxOf(tmp, pre[u1][u2])
                    }
                if (tmp != -1) {
                    tmp += grid[x1][y1]
                    if (x1 != x2)
                        tmp += grid[x2][y2]
                }
                cur[x1][x2] = tmp
            }
        }
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return maxOf(0, pre[n - 1][n - 1])
}