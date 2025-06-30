package cn_solution

fun maxDistance(grid: Array<IntArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val range = grid.indices
    val q = ArrayList<IntArray>()
    val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    for (i in range)
        for (j in range)
            if (grid[i][j] == 1)
                q.add(intArrayOf(i, j, 0))
    var ans = -1
    while (q.isNotEmpty()) {
        val (x, y, z) = q.removeFirst()
        for (k in d.indices.step(2)) {
            val u = x + d[k]
            val v = y + d[k + 1]
            if (u in range && v in range && grid[u][v] == 0 && dist[u][v] > z + 1) {
                ans = z + 1
                dist[u][v] = ans
                q.add(intArrayOf(u, v, z + 1))
            }
        }
    }
    return ans
}