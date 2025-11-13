package cn_solution

fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    val m = grid[0].size
    val dp = Array(m + 1) { IntArray(k) }
    dp[1][0] = 1
    val tmp = IntArray(k)
    for (line in grid) {
        for (i in 0 until m) {
            val num = line[i]
            for (j in 0 until k)
                tmp[(j + num) % k] = (dp[i][j] + dp[i + 1][j]) % 1000000007
            tmp.copyInto(dp[i + 1])
        }
    }
    return dp[m][0]
}