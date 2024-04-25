package cn_solution

fun surfaceArea(grid: Array<IntArray>): Int {
    val row = grid.indices
    val col = grid[0].indices
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    var area = 0
    for (i in row)
        for (j in col) {
            if (grid[i][j] == 0)
                continue
            area += 2
            for (t in d.indices step 2) {
                val x = i + d[t]
                val y = j + d[t + 1]
                area += if (x in row && y in col)
                    maxOf(0, grid[i][j] - grid[x][y])
                else
                    grid[i][j]
            }
        }
    return area
}