package cn_solution

fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
    val w = grid[0].size
    val u = 1 shl w
    val dp = IntArray(u) { -1 }
    for (i in grid.indices) {
        val s = (0 until w).sumOf { j -> grid[i][j] shl j }
        if (s == 0)
            return listOf(i)
        dp[s] = i
    }
    for (i in 0 until w) {
        val t = 1 shl i
        var j = t
        while (j < u) {
            if (dp[j] == -1)
                dp[j] = dp[j xor t]
            if (dp[j] != -1 && dp[j xor (u - 1)] != -1) {
                val x = dp[j]
                val y = dp[j xor (u - 1)]
                val min = minOf(x, y)
                return listOf(min, x xor y xor min)
            }
            j = (j + 1) or t
        }
    }
    return emptyList()
}