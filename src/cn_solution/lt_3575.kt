package cn_solution

fun goodSubtreeSum(vals: IntArray, par: IntArray): Int {
    var ans = 0L
    val n = vals.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[par[i]].add(i)
    fun dfs(u: Int, p: Int): LongArray {
        val dp = LongArray(1024) { -1 }
        dp[0] = 0L
        var msk = 0
        var tmp = vals[u]
        do {
            val bit = 1 shl (tmp % 10)
            if (msk and bit != 0) {
                msk = -1
                break
            }
            msk = msk or bit
            tmp /= 10
        } while (tmp != 0)
        if (msk != -1)
            dp[msk] = vals[u] + 0L
        for (v in g[u])
            if (v != p) {
                val sub = dfs(v, u)
                for (i in 1 until 1024)
                    if (sub[i] != -1L)
                        for (j in (1023 xor i) downTo 0)
                            if (dp[j] != -1L && i and j == 0)
                                dp[i or j] = maxOf(dp[i or j], sub[i] + dp[j])
            }
        ans += dp.max()
        return dp
    }
    dfs(0, -1)
    return ans.mod(1000000007)
}