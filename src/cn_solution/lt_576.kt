package cn_solution

fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    val modulo = 1000000007
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val row = 0 until m
    val col = 0 until n
    var ans = 0
    val dp = Array(maxMove + 1) { Array(m) { IntArray(n) } }
    dp[0][startRow][startColumn] = 1
    for (k in 0 until maxMove) {
        for (i in row)
            for (j in col)
                if (dp[k][i][j] != 0)
                    for (t in dir.indices.step(2)) {
                        val x = i + dir[t]
                        val y = j + dir[t + 1]
                        if (x in row && y in col)
                            dp[k + 1][x][y] = (dp[k + 1][x][y] + dp[k][i][j]) % modulo
                        else
                            ans = (ans + dp[k][i][j]) % modulo
                    }
    }
    return ans
}