package cn_solution

fun hasValidPath(grid: Array<IntArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    val vis = Array(n) { BooleanArray(m) }
    val dir = arrayOf(0, -1, 0, 1, -1, 0, 1, 0)
    val str = intArrayOf(0b101010, 0b1010010, 0b1100100, 0b11100)
    fun move(x: Int, y: Int, d: Int) = 1 shl grid[x][y] and str[d] != 0
    fun dfs(x: Int, y: Int): Boolean {
        if (x == n - 1 && y == m - 1)
            return true
        vis[x][y] = true
        for (i in 0 until 4) {
            val u = x + dir[i * 2]
            val v = y + dir[i * 2 + 1]
            if (u !in 0 until n || v !in 0 until m || vis[u][v])
                continue
            if (move(x, y, i) && move(u, v, i xor 1) && dfs(u, v))
                return true
        }
        return false
    }
    return dfs(0, 0)
}