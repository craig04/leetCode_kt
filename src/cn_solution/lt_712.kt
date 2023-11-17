package cn_solution

fun minimumDeleteSum(s1: String, s2: String): Int {
    val dp = IntArray(s2.length + 1)
    for (j in s2.indices)
        dp[j + 1] = dp[j] + s2[j].code
    for (i in s1.indices) {
        var pre = dp[0]
        dp[0] += s1[i].code
        for (j in s2.indices) {
            val cur = if (s1[i] == s2[j])
                pre
            else
                minOf(dp[j + 1] + s1[i].code, dp[j] + s2[j].code)
            pre = dp[j + 1]
            dp[j + 1] = cur
        }
    }
    return dp.last()
}