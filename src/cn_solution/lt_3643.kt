package cn_solution

fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
    var i = x - 1
    var j = x + k
    while (++i < --j) {
        for (t in y until y + k) {
            val number = grid[i][t]
            grid[i][t] = grid[j][t]
            grid[j][t] = number
        }
    }
    return grid
}