package cn_solution

fun countNegatives(grid: Array<IntArray>): Int {
    val m = grid[0].size
    var i = grid.lastIndex
    var j = 0
    var result = 0
    while (i >= 0) {
        while (j < m) {
            if (grid[i][j] < 0)
                break
            j++
        }
        result += m - j
        i--
    }
    return result
}
