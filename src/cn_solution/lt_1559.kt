package cn_solution

fun containsCycle_unionFind(grid: Array<CharArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    val p = IntArray(n * m) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (x in grid.indices)
        for (y in grid[x].indices) {
            val z = x * m + y
            val a = find(z)
            if (x != 0 && grid[x][y] == grid[x - 1][y]) {
                val b = find(z - m)
                if (a == b)
                    return true
                p[b] = a
            }
            if (y != 0 && grid[x][y] == grid[x][y - 1]) {
                val b = find(z - 1)
                if (a == b)
                    return true
                p[b] = a
            }
        }
    return false
}

fun containsCycle_dfs(grid: Array<CharArray>): Boolean {
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid[0].size
    val vis = Array(n) { BooleanArray(m) }
    fun dfs(x: Int, y: Int, px: Int, py: Int): Boolean {
        vis[x][y] = true
        return dir.indices.step(2).any { i ->
            val nx = x + dir[i]
            val ny = y + dir[i + 1]
            (nx != px || ny != py) &&
                    nx in 0 until n &&
                    ny in 0 until m &&
                    grid[nx][ny] == grid[x][y] &&
                    (vis[nx][ny] || dfs(nx, ny, x, y))
        }
    }
    return (0 until n).any { i ->
        (0 until m).any { j ->
            !vis[i][j] && dfs(i, j, -1, -1)
        }
    }
}