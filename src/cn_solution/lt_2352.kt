package cn_solution

fun equalPairs(grid: Array<IntArray>): Int {
    val row = HashMap<Int, Int>()
    val col = HashMap<Int, Int>()
    for (i in grid.indices) {
        var r = 0
        var c = 0
        for (j in grid.indices) {
            r = r * 10001 + grid[i][j]
            c = c * 10001 + grid[j][i]
        }
        row[r] = (row[r] ?: 0) + 1
        col[c] = (col[c] ?: 0) + 1
    }
    return col.entries.sumBy { (k, v) -> (row[k] ?: 0) * v }
}