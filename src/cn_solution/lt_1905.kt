package cn_solution

fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid1.size
    val m = grid1.first().size
    val row = grid1.indices
    val col = grid1.first().indices
    val vis = Array(n) { BooleanArray(m) }
    fun dfs(i: Int, j: Int): Boolean {
        vis[i][j] = true
        var res = grid1[i][j] == 1
        for (t in dir.indices.step(2)) {
            val x = i + dir[t]
            val y = j + dir[t + 1]
            if (x in row && y in col && grid2[x][y] == 1 && !vis[x][y] && !dfs(x, y))
                res = false
        }
        return res
    }

    var ans = 0
    for (i in row)
        for (j in col)
            if (grid2[i][j] == 1 && !vis[i][j] && dfs(i, j))
                ans++
    return ans
}