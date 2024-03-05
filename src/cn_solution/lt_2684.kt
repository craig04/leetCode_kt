package cn_solution

fun maxMoves(grid: Array<IntArray>): Int {
    val m = grid[0].size
    val row = grid.indices
    val col = grid[0].indices
    val q = grid.indices.mapTo(ArrayDeque()) { it * m }
    val vis = BooleanArray(grid.size * m)
    var result = 0
    while (q.isNotEmpty()) {
        val idx = q.removeFirst()
        val x = idx / m
        val y = idx % m
        result = maxOf(result, y)
        fun move(u: Int, v: Int) {
            if (u !in row || v !in col)
                return
            val pos = u * m + v
            if (grid[x][y] < grid[u][v] && !vis[pos]) {
                vis[pos] = true
                q.addLast(pos)
            }
        }
        move(x - 1, y + 1)
        move(x, y + 1)
        move(x + 1, y + 1)
    }
    return result
}