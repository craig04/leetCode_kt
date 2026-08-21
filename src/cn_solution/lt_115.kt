package cn_solution

fun numDistinct(s: String, t: String): Int {
    val dp = IntArray(t.length + 1)
    dp[0] = 1
    for (i in s.indices)
        for (j in t.indices.reversed())
            if (s[i] == t[j])
                dp[j + 1] += dp[j]
    return dp.last()
}