package cn_solution

import java.math.BigInteger

fun countNumbers(l: String, r: String, b: Int): Int {
    val max = BigInteger(r).toString(b).toCharArray()
    val n = max.size
    val min = CharArray(n) { '0' }
    BigInteger(l).toString(b).run { toCharArray(min, n - length) }
    val dp = Array(n) { IntArray(10) { -1 } }
    fun dfs(i: Int, pre: Int, low: Boolean, high: Boolean): Int {
        if (i == n)
            return 1
        var res = dp[i][pre]
        if (low || high || res == -1) {
            val x = maxOf('0' + pre, if (low) min[i] else '0')
            val y = if (high) max[i] else '0' + b - 1
            res = (x..y).fold(0L) { acc, it ->
                acc + dfs(i + 1, it - '0', low && it == min[i], high && it == max[i])
            }.mod(1000000007)
            if (!low && !high)
                dp[i][pre] = res
        }
        return res
    }
    return dfs(0, 0, true, true)
}