package cn_solution

fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val n = grid.size
    val m = grid[0].size
    val row = IntArray(n)
    val col = IntArray(m)
    for (i in 0 until n)
        for (j in 0 until m) {
            row[i] += grid[i][j]
            col[j] += grid[i][j]
        }
    return Array(n) { i -> IntArray(m) { j -> 2 * (row[i] + col[j]) - m - n } }
}