package cn_solution

fun uniquePaths(grid: Array<IntArray>): Int {
    val modulo = 1000000007
    val m = grid[0].size
    val r = IntArray(m + 1)
    val d = IntArray(m + 1)
    d[1] = 1
    for (line in grid)
        for (j in 0 until m) {
            if (line[j] == 0) {
                val sum = (r[j] + d[j + 1]) % modulo
                r[j + 1] = sum
                d[j + 1] = sum
            } else {
                r[j + 1] = d[j + 1]
                d[j + 1] = r[j]
            }
        }
    return r[m]
}