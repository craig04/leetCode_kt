package cn_solution

fun maxScore(grid: List<List<Int>>): Int {
    val dp = IntArray(grid.first().size + 1) { Int.MIN_VALUE / 2 }
    var ans = Int.MIN_VALUE
    for (i in grid.indices.reversed()) {
        for (j in grid[i].indices.reversed()) {
            val max = maxOf(dp[j], dp[j + 1])
            ans = maxOf(ans, max - grid[i][j])
            dp[j] = maxOf(max, grid[i][j])
        }
    }
    return ans
}