package cn_solution

fun maxScore(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid.first().size
    fun maxSubarray(a: IntArray): Int {
        var res = Int.MIN_VALUE
        var pre = a[0]
        for (i in 1 until a.size) {
            res = maxOf(res, pre + a[i])
            pre = maxOf(pre, 0) + a[i]
        }
        return res
    }

    var ans = grid.maxOf(::maxSubarray)
    val col = IntArray(n)
    for (j in 0 until m) {
        for (i in 0 until n)
            col[i] = grid[i][j]
        ans = maxOf(ans, maxSubarray(col))
    }
    for (i in 1 until n - 1)
        for (j in 1 until m - 1)
            ans = maxOf(ans, grid[i][j])
    return ans
}