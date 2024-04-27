package cn_solution

private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1)
    dp[s.length] = true
    for (i in s.indices.reversed()) {
        dp[i] = wordDict.any {
            s.startsWith(it, i) && dp[i + it.length]
        }
    }
    return dp[0]
}
