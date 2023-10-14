package cn_lcr

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length)
        return false
    val dp = BooleanArray(s2.length + 1)
    dp[0] = true
    s2.forEachIndexed { j, c -> dp[j + 1] = dp[j] && s2[j] == s3[j] }
    for (i in s1.indices) {
        if (s1[i] != s3[i])
            dp[0] = false
        for (j in s2.indices) {
            dp[j + 1] = (dp[j] && s2[j] == s3[i + j + 1]) || (dp[j + 1] && s1[i] == s3[i + j + 1])
        }
    }
    return dp[s2.length]
}