package cn_solution

fun minimumSum(grid: Array<IntArray>): Int {

    fun area(g: Array<IntArray>, left: Int, top: Int, right: Int, bottom: Int): Int {
        var (l, t, r, b) = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, -1, -1)
        for (i in top..bottom)
            for (j in left..right)
                if (g[i][j] == 1) {
                    l = minOf(l, j)
                    t = minOf(t, i)
                    r = maxOf(r, j)
                    b = maxOf(b, i)
                }
        return if (r == -1) Int.MAX_VALUE / 3 else (r - l + 1) * (b - t + 1)
    }

    fun solve(g: Array<IntArray>): Int {
        val n = g.lastIndex
        val m = g[0].lastIndex
        var ans = Int.MAX_VALUE
        for (x in 0..n - 2)
            for (y in x + 1 until n) {
                ans = minOf(
                    ans, area(g, 0, 0, m, x)
                            + area(g, 0, x + 1, m, y)
                            + area(g, 0, y + 1, m, n)
                )
            }
        for (x in 0 until n) {
            for (y in 0 until m) {
                ans = minOf(
                    ans, area(g, 0, 0, m, x)
                            + area(g, 0, x + 1, y, n)
                            + area(g, y + 1, x + 1, m, n)
                )
                ans = minOf(
                    ans, area(g, 0, 0, y, x)
                            + area(g, y + 1, 0, m, x)
                            + area(g, 0, x + 1, m, n)
                )
            }
        }
        return ans
    }

    val ans = solve(grid)
    val n = grid.size
    val m = grid[0].size
    val rotate = Array(m) { IntArray(n) }
    for (i in 0 until n)
        for (j in 0 until m)
            rotate[j][i] = grid[i][j]
    return minOf(ans, solve(rotate))
}