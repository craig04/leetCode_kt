package cn_solution

fun largestMagicSquare(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val rows = Array(n) { IntArray(m + 1) }
    val cols = Array(m) { IntArray(n + 1) }
    for (i in 0 until n)
        for (j in 0 until m) {
            rows[i][j + 1] = rows[i][j] + grid[i][j]
            cols[j][i + 1] = cols[j][i] + grid[i][j]
        }
    fun isMagicSquare(i: Int, j: Int, len: Int): Boolean {
        var sum1 = 0
        var sum2 = 0
        for (t in 0 until len) {
            sum1 += grid[i + t][j + t]
            sum2 += grid[i + t][j + len - t - 1]
        }
        return sum1 == sum2 && (0 until len).all { t ->
            rows[i + t][j + len] - rows[i + t][j] == sum1 && cols[j + t][i + len] - cols[j + t][i] == sum1
        }
    }
    for (len in minOf(n, m) downTo 2)
        for (i in 0..n - len)
            for (j in 0..m - len)
                if (isMagicSquare(i, j, len))
                    return len
    return 1
}