package cn_solution

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length)
        return false
    val dp = BooleanArray(s2.length + 1)
    dp[0] = true
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            val k = i + j - 1
            if (i != 0)
                dp[j] = dp[j] && s1[i - 1] == s3[k]
            if (j != 0)
                dp[j] = dp[j] || (dp[j - 1] && s2[j - 1] == s3[k])
        }
    }
    return dp[s2.length]
}