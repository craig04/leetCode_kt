package cn_solution

fun maxProductPath(grid: Array<IntArray>): Int {
    val m = grid[0].size
    val max = LongArray(m)
    val min = LongArray(m)
    for (i in grid.indices)
        for (j in grid[i].indices) {
            val num = grid[i][j] + 0L
            if (i == 0 && j == 0) {
                max[j] = num
                min[j] = num
                continue
            }
            var x = Long.MIN_VALUE
            var y = Long.MAX_VALUE
            if (i != 0) {
                x = maxOf(x, max[j] * num, min[j] * num)
                y = minOf(y, max[j] * num, min[j] * num)
            }
            if (j != 0) {
                x = maxOf(x, max[j - 1] * num, min[j - 1] * num)
                y = minOf(y, max[j - 1] * num, min[j - 1] * num)
            }
            max[j] = x
            min[j] = y
        }
    return if (max[m - 1] < 0) -1 else max[m - 1].mod(1000000007)
}