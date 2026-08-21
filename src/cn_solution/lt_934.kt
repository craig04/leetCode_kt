package cn_solution

fun shortestBridge(grid: Array<IntArray>): Int {
    val row = grid.indices
    val col = grid.first().indices
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val q = ArrayDeque<IntArray>()
    find@ for (i in row)
        for (j in col)
            if (grid[i][j] == 1) {
                q += intArrayOf(i, j)
                grid[i][j] = -1
                break@find
            }
    var pos = 0
    while (pos != q.size) {
        val (i, j) = q[pos++]
        for (t in dir.indices.step(2)) {
            val x = i + dir[t]
            val y = j + dir[t + 1]
            if (x in row && y in col && grid[x][y] == 1) {
                grid[x][y] = -1
                q += intArrayOf(x, y)
            }
        }
    }
    var ans = 0
    while (q.isNotEmpty()) {
        repeat(q.size) {
            val (i, j) = q.removeFirst()
            for (t in dir.indices.step(2)) {
                val x = i + dir[t]
                val y = j + dir[t + 1]
                if (x in row && y in col) {
                    if (grid[x][y] == 1)
                        return ans
                    if (grid[x][y] == 0) {
                        grid[x][y] = -1
                        q += intArrayOf(x, y)
                    }
                }
            }
        }
        ans++
    }
    return 0
}