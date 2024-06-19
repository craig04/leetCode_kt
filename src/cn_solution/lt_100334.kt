package cn_solution

fun minimumArea(grid: Array<IntArray>): Int {
    var left = Int.MAX_VALUE
    var top = Int.MAX_VALUE
    var right = 0
    var bottom = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                left = minOf(left, j)
                top = minOf(top, i)
                right = maxOf(right, j)
                bottom = maxOf(bottom, i)
            }
        }
    }
    return (right - left + 1) * (bottom - top + 1)
}