package cn_solution

fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    val range = grid.indices
    val row = IntArray(grid.size)
    val col = IntArray(grid.size)
    for (i in range)
        for (j in range) {
            row[i] = maxOf(row[i], grid[i][j])
            col[j] = maxOf(col[j], grid[i][j])
        }
    return range.sumOf { i -> range.sumOf { j -> minOf(row[i], col[j]) - grid[i][j] } }
}