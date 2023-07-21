package cn_solution

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val dp = IntArray(obstacleGrid[0].size + 1)
    dp[1] = 1
    for (line in obstacleGrid) {
        for (i in line.indices) {
            if (line[i] == 1)
                dp[i + 1] = 0
            else
                dp[i + 1] += dp[i]
        }
    }
    return dp.last()
}