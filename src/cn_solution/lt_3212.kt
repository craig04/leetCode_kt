package cn_solution

fun numberOfSubmatrices(grid: Array<CharArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val x = Array(n + 1) { IntArray(m + 1) }
    val y = Array(n + 1) { IntArray(m + 1) }
    var ans = 0
    for (i in 1..n)
        for (j in 1..m) {
            x[i][j] = x[i - 1][j] + x[i][j - 1] - x[i - 1][j - 1]
            y[i][j] = y[i - 1][j] + y[i][j - 1] - y[i - 1][j - 1]
            when (grid[i - 1][j - 1]) {
                'X' -> x[i][j]++
                'Y' -> y[i][j]++
            }
            if (x[i][j] != 0 && x[i][j] == y[i][j])
                ans++
        }
    return ans
}