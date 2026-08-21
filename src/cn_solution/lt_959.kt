package cn_solution

fun regionsBySlashes(grid: Array<String>): Int {
    val n = grid.size
    val p = IntArray(n * n * 4) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int) {
        p[find(x)] = find(y)
    }
    for (i in grid.indices)
        for (j in grid[i].indices) {
            val t = (i * n + j) * 4
            if (grid[i][j] != '\\') {
                union(t + 0, t + 3)
                union(t + 1, t + 2)
            }
            if (grid[i][j] != '/') {
                union(t + 0, t + 1)
                union(t + 2, t + 3)
            }
            if (i != 0)
                union(t, t - n * 4 + 2)
            if (j != 0)
                union(t + 3, t - 3)
        }
    return p.mapTo(HashSet(), ::find).size
}