package cn_solution

fun largestIsland(grid: Array<IntArray>): Int {
    var result = 0
    var idx = 0
    val n = grid.size - 1
    val area = HashMap<Int, Int>()
    val indices = Array(n + 1) { IntArray(n + 1) }

    fun count(i: Int, j: Int, function: (Int, Int) -> Int): Int {
        var temp = 1
        if (i != 0) temp += function(i - 1, j)
        if (i != n) temp += function(i + 1, j)
        if (j != 0) temp += function(i, j - 1)
        if (j != n) temp += function(i, j + 1)
        return temp
    }

    fun dfs(i: Int, j: Int): Int {
        if (grid[i][j] == 0 || indices[i][j] != 0)
            return 0
        indices[i][j] = idx
        return count(i, j) { x, y -> dfs(x, y) }
    }
    for (i in 0..n)
        for (j in 0..n) {
            ++idx
            val temp = dfs(i, j)
            if (temp != 0) {
                area[idx] = temp
                result = maxOf(result, temp)
            }
        }
    for (i in 0..n)
        for (j in 0..n)
            if (grid[i][j] != 1) {
                val join = hashSetOf(0)
                result = maxOf(result, count(i, j) { x, y ->
                    indices[x][y].let { if (join.add(it)) area[it] ?: 0 else 0 }
                })
            }
    return result
}
