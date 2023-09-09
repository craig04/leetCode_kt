package cn_lcr

fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val row = matrix.indices
    val col = matrix[0].indices
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val dp = Array(matrix.size) { IntArray(matrix[0].size) }
    fun dfs(i: Int, j: Int): Int {
        if (dp[i][j] == 0) {
            for (t in d.indices step 2) {
                val x = i + d[t]
                val y = j + d[t + 1]
                if (x in row && y in col && matrix[i][j] > matrix[x][y]) {
                    dp[i][j] = maxOf(dp[i][j], dfs(x, y))
                }
            }
            dp[i][j]++
        }
        return dp[i][j]
    }
    return row.maxOf { i -> col.maxOf { j -> dfs(i, j) } }
}