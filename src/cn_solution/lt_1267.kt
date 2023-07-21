package cn_solution

fun countServers(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val row = IntArray(m)
    val col = IntArray(n)
    for (i in row.indices)
        for (j in col.indices)
            if (grid[i][j] == 1) {
                row[i]++
                col[j]++
            }
    return row.indices.sumBy { i ->
        col.indices.count { j ->
            grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)
        }
    }
}