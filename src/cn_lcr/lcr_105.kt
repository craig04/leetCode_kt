package cn_lcr

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var result = 0
    val n = grid.size - 1
    val m = grid[0].size - 1
    val visit = Array(n + 1) { BooleanArray(m + 1) }
    fun dfs(x: Int, y: Int): Int {
        if (grid[x][y] == 0 || visit[x][y])
            return 0
        visit[x][y] = true
        var area = 1
        if (x != 0) area += dfs(x - 1, y)
        if (x != n) area += dfs(x + 1, y)
        if (y != 0) area += dfs(x, y - 1)
        if (y != m) area += dfs(x, y + 1)
        return area
    }
    for (i in 0..n)
        for (j in 0..m)
            result = maxOf(result, dfs(i, j))
    return result
}