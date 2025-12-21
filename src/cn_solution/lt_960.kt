package cn_solution

private fun minDeletionSize(strs: Array<String>): Int {
    fun test(i: Int, j: Int): Boolean {
        for (str in strs)
            if (str[i] > str[j])
                return false
        return true
    }

    val m = strs[0].length
    val dp = IntArray(m) { 1 }
    for (j in 1 until m)
        for (i in 0 until j)
            if (dp[i] + 1 > dp[j] && test(i, j))
                dp[j] = dp[i] + 1
    return m - dp.max()
}