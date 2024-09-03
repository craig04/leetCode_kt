package cn_solution

private fun maxScore(grid: List<List<Int>>): Int {
    val n = grid.size
    val s = 1 shl n
    val line = IntArray(101)
    for (i in grid.indices)
        for (num in grid[i])
            line[num] = 1.shl(i) or line[num]
    val dp = IntArray(s)
    for (i in line.indices.reversed()) {
        val mask = line[i]
        if (mask == 0)
            continue
        for (j in s - 1 downTo 0) {
            var t = mask
            while (t != 0) {
                val k = t.takeLowestOneBit()
                if (j and k != 0)
                    dp[j] = maxOf(dp[j], dp[j xor k] + i)
                t -= k
            }
        }
    }
    return dp.max()
}