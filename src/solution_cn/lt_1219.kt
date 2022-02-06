package solution_cn

fun getMaximumGold(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val steps = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    var gold = 0
    var result = 0
    fun dfs(i: Int, j: Int) {
        val temp = grid[i][j]
        grid[i][j] = 0
        gold += temp
        result = maxOf(result, gold)
        for (s in steps) {
            val u = i + s.first
            val v = j + s.second
            if (u in 0 until n && v in 0 until m && grid[u][v] != 0) {
                dfs(u, v)
            }
        }
        gold -= temp
        grid[i][j] = temp
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (grid[i][j] != 0) {
                dfs(i, j)
            }
        }
    }
    return result
}