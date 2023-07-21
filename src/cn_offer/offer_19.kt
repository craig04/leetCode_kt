package cn_offer

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true
    fun match(i: Int, j: Int) = i != 0 && (p[j - 1] == '.' || p[j - 1] == s[i - 1])
    for (i in 0..s.length) {
        for (j in 1..p.length) {
            dp[i][j] = if (p[j - 1] != '*')
                match(i, j) && dp[i - 1][j - 1]
            else {
                dp[i][j - 2] || (match(i, j - 1) && dp[i - 1][j])
            }
        }
    }
    return dp[s.length][p.length]
}