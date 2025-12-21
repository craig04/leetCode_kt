package cn_solution

fun findMaxFish(grid: Array<IntArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val q = ArrayDeque<IntArray>()
    val row = grid.indices
    val col = grid[0].indices
    var ans = 0
    for (i in row)
        for (j in col) {
            if (grid[i][j] == 0)
                continue
            var fish = 0
            q.add(intArrayOf(i, j))
            fish += grid[i][j]
            grid[i][j] = 0
            while (q.isNotEmpty()) {
                val (x, y) = q.removeFirst()
                for (t in d.indices.step(2)) {
                    val u = x + d[t]
                    val v = y + d[t + 1]
                    if (u in row && v in col && grid[u][v] > 0) {
                        q.add(intArrayOf(u, v))
                        fish += grid[u][v]
                        grid[u][v] = 0
                    }
                }
            }
            ans = maxOf(ans, fish)
        }
    return ans
}