package cn_solution

fun minimumObstacles(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid.first().size
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val dis = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val q = ArrayDeque<IntArray>()
    dis[0][0] = 0
    q.addFirst(intArrayOf(0, 0, 0))
    while (q.isNotEmpty()) {
        val (s, i, j) = q.removeFirst()
        if (s > dis[i][j])
            continue
        for (t in d.indices step 2) {
            val x = i + d[t]
            val y = j + d[t + 1]
            if (x in 0 until n && y in 0 until m && s + grid[x][y] < dis[x][y]) {
                dis[x][y] = s + grid[x][y]
                if (grid[x][y] == 0)
                    q.addFirst(intArrayOf(dis[x][y], x, y))
                else
                    q.addLast(intArrayOf(dis[x][y], x, y))
            }
        }
    }
    return dis[n - 1][m - 1]
}