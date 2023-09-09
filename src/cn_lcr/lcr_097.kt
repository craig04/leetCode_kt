package cn_lcr

fun numDistinct(s: String, t: String): Int {
    val m = t.length
    if (s.length < m)
        return 0
    val dp = IntArray(m + 1)
    dp[0] = 1
    for (i in s.indices)
        for (j in t.indices.reversed())
            if (s[i] == t[j])
                dp[j + 1] += dp[j]
    return dp[m]
}