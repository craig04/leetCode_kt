package cn_solution

private fun canPartitionGrid(grid: Array<IntArray>): Boolean {
    fun test(grid: Array<IntArray>): Boolean {
        val n = grid.size
        val m = grid[0].size
        var sum = 0L
        val row = LongArray(n)
        for (i in 0 until n) {
            for (j in 0 until m) {
                sum += grid[i][j]
                row[i] += grid[i][j]
            }
        }
        var x = row[0]
        var y = sum - row[0]
        if (x == y || x - grid[0][0] == y || x - grid[0][m - 1] == y)
            return true
        val set = grid[0].mapTo(HashSet()) { it.toLong() }
        for (i in 1 until n - 1) {
            x += row[i]
            y -= row[i]
            if (x == y)
                return true
            if (m == 1) {
                if (x - row[0] == y || x - row[i] == y)
                    return true
            } else {
                grid[i].mapTo(set) { it.toLong() }
                if ((x - y) in set)
                    return true
            }
        }
        return false
    }
    if (test(grid) || test(grid.reversedArray()))
        return true
    val rotate = Array(grid[0].size) { IntArray(grid.size) }
    for (i in grid.indices)
        for (j in grid[0].indices)
            rotate[j][i] = grid[i][j]
    return test(rotate) || test(rotate.reversedArray())
}