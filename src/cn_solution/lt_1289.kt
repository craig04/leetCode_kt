package cn_solution

private fun minFallingPathSum(grid: Array<IntArray>): Int {
    var minimal = 0
    var index = -1
    var second = 0
    val dp = IntArray(grid[0].size)
    for (line in grid) {
        line.forEachIndexed { i, n ->
            dp[i] = n + if (i == index) second else minimal
        }
        minimal = Int.MAX_VALUE
        second = Int.MAX_VALUE
        dp.forEachIndexed { i, n ->
            if (n < minimal) {
                second = minimal
                minimal = n
                index = i
            } else if (n < second) {
                second = n
            }
        }
    }
    return dp.min()!!
}