package cn_solution

fun minCost(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val row = grid.indices
    val col = grid[0].indices
    val d = intArrayOf(0, 0, 0, 1, 0, -1, 1, 0, -1, 0)
    val cost = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val q = ArrayDeque<IntArray>()
    cost[0][0] = 0
    q.addFirst(intArrayOf(0, 0, 0))
    while (q.isNotEmpty()) {
        val (i, j, c) = q.removeFirst()
        if (c > cost[i][j])
            continue
        for (t in 2 until d.size step 2) {
            val x = i + d[t]
            val y = j + d[t + 1]
            if (x !in row || y !in col)
                continue
            var next = c
            if (grid[i][j] != t shr 1)
                next += 1
            if (next >= cost[x][y])
                continue
            cost[x][y] = next
            val data = intArrayOf(x, y, next)
            if (next == c)
                q.addFirst(data)
            else
                q.addLast(data)
        }
    }
    return cost[n - 1][m - 1]
}