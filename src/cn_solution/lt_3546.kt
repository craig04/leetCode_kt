package cn_solution

private fun canPartitionGrid(grid: Array<IntArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    var sum = 0L
    val row = LongArray(n)
    val col = LongArray(m)
    for (i in 0 until n) {
        for (j in 0 until m) {
            sum += grid[i][j]
            row[i] += grid[i][j]
            col[j] += grid[i][j]
        }
    }
    if (sum % 2 != 0L)
        return false
    sum /= 2
    var x = 0L
    var y = 0L
    return row.any {
        x += it
        x == sum
    } || col.any {
        y += it
        y == sum
    }
}