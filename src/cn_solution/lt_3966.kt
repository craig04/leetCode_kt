package cn_solution

fun goodIntegers(l: Long, r: Long, k: Int): Long {
    val highS = r.toString().toCharArray()
    val n = highS.size
    val lowS = CharArray(n) { '0' }
    val s = l.toString()
    s.toCharArray(lowS, lowS.size - s.length)
    val dp = Array(n) { LongArray(10) { -1 } }
    fun dfs(i: Int, pre: Int, limitLow: Boolean, limitHigh: Boolean, zero: Boolean): Long {
        if (i == n)
            return 1
        if (!limitLow && !limitHigh && !zero && dp[i][pre] != -1L)
            return dp[i][pre]
        var low = 0
        var high = 9
        if (!zero) {
            low = maxOf(low, pre - k)
            high = minOf(high, pre + k)
        }
        if (limitLow)
            low = maxOf(low, lowS[i] - '0')
        if (limitHigh)
            high = minOf(high, highS[i] - '0')
        val res = (low..high).sumOf { j ->
            dfs(
                i + 1, j,
                limitLow && j == lowS[i] - '0',
                limitHigh && j == highS[i] - '0',
                zero && j == 0
            )
        }
        if (!limitLow && !limitHigh && !zero)
            dp[i][pre] = res
        return res
    }
    return dfs(0, 0, true, true, true)
}