package cn_solution

fun countPathsWithXorValue(grid: Array<IntArray>, k: Int): Int {
    val modulo = 1000000007
    val max = grid.maxOf { it.max() }
    val u = 1.shl(32 - max.countLeadingZeroBits())
    if (k >= u)
        return 0
    val dp = Array(grid[0].size) { IntArray(u) }
    dp[0][0] = 1
    val a = IntArray(u)
    for (line in grid) {
        for (i in line.indices) {
            a.fill(0)
            for (j in 0 until u) {
                val x = j xor line[i]
                if (i != 0)
                    a[j] = dp[i - 1][x]
                a[j] = (a[j] + dp[i][x]) % modulo
            }
            a.copyInto(dp[i])
        }
    }
    return dp.last()[k]
}