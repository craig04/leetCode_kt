package cn_solution

private const val MOD = 1000000007L

fun dieSimulator(n: Int, rollMax: IntArray): Int {
    val dp = Array(6) { LongArray(16) }
    val next = LongArray(6)
    dp.forEach { it[1] = 1 }
    repeat(n - 1) {
        next.fill(0)
        for (i in 0 until 6) {
            for (j in rollMax[i] downTo 1) {
                for (k in 0 until 6)
                    if (i != k)
                        next[k] += dp[i][j]
                if (j != 1)
                    dp[i][j] = dp[i][j - 1]
            }
        }
        for (i in 0 until 6)
            dp[i][1] = next[i] % MOD
    }
    return (dp.sumOf { it.sum() } % MOD).toInt()
}