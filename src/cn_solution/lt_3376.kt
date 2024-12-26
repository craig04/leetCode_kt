package cn_solution

fun findMinimumTime(strength: List<Int>, k: Int): Int {
    val n = strength.size
    val dp = IntArray(1 shl n) { Int.MAX_VALUE }
    dp[0] = 0
    fun dfs(locks: Int): Int {
        if (dp[locks] == Int.MAX_VALUE) {
            val x = 1 + (n - locks.countOneBits()) * k
            var t = locks
            while (t != 0) {
                val b = t.takeLowestOneBit()
                val i = b.countTrailingZeroBits()
                t = t xor b
                dp[locks] = minOf(dp[locks], (strength[i] + x - 1) / x + dfs(locks xor b))
            }
        }
        return dp[locks]
    }
    return dfs(dp.lastIndex)
}