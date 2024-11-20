package cn_solution

fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid[0].size
    val h = Array(n) { IntArray(m) }
    val q = ArrayDeque<IntArray>()
    h[0][0] = health - grid[0][0]
    if (h[0][0] <= 0)
        return false
    q.addLast(intArrayOf(0, 0))
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        if (x == n - 1 && y == m - 1)
            return true
        for (t in d.indices.step(2)) {
            val u = x + d[t]
            val v = y + d[t + 1]
            if (u in 0 until n && v in 0 until m && h[u][v] == 0) {
                if (grid[u][v] == 0) {
                    h[u][v] = h[x][y]
                    q.addFirst(intArrayOf(u, v))
                } else if (h[x][y] > 1) {
                    h[u][v] = h[x][y] - 1
                    q.addLast(intArrayOf(u, v))
                }
            }
        }
    }
    return false
}