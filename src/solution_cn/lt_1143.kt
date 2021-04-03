package solution_cn

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val s1 = text1.toCharArray()
    val s2 = text2.toCharArray()
    val dp = Array(s1.size + 1) { IntArray(s2.size + 1) }
    for (i in s1.indices.reversed()) {
        for (j in s2.indices.reversed()) {
            if (s1[i] == s2[j]) {
                dp[i][j] = dp[i + 1][j + 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }
    return dp[0][0]
}