package cn_solution

fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val q = ArrayDeque<Int>()
    val dist = Array(n) { IntArray(m) { -1 } }
    if (grid[0][0] == 0) {
        q.add(0)
        dist[0][0] = 1
    }
    while (q.isNotEmpty()) {
        val t = q.removeFirst()
        val i = t / m
        val j = t % m
        val d = dist[i][j]
        for (x in -1..1)
            for (y in -1..1) {
                val a = i + x
                val b = j + y
                if (a !in 0 until n || b !in 0 until m || grid[a][b] != 0 || dist[a][b] != -1)
                    continue
                dist[a][b] = d + 1
                q.add(a * m + b)
            }
    }
    return dist[n - 1][m - 1]
}
