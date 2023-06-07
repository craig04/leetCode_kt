package cn_solution

fun closedIsland(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val row = grid.indices
    val col = grid[0].indices
    val visit = Array(n) { BooleanArray(m) }
    val x = intArrayOf(-1, 0, 0, 1)
    val y = intArrayOf(0, -1, 1, 0)
    var closed: Int
    fun dfs(i: Int, j: Int) {
        visit[i][j] = true
        if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
            closed = 0
        x.indices.forEach {
            val p = x[it] + i
            val q = y[it] + j
            if (p in row && q in col && !visit[p][q] && grid[p][q] == 0)
                dfs(p, q)
        }
    }

    var result = 0
    for (i in row)
        for (j in col)
            if (!visit[i][j] && grid[i][j] == 0) {
                closed = 1
                dfs(i, j)
                result += closed
            }
    return result
}