package cn_solution

fun numWays(words: Array<String>, target: String): Int {
    val modulo = 1000000007L
    val n = words[0].length
    val m = target.length
    val cnt = Array(n) { LongArray(m) }
    for (i in words[0].indices) {
        val temp = LongArray(26)
        for (word in words)
            temp[word[i] - 'a']++
        for (j in target.indices) {
            cnt[i][j] += temp[target[j] - 'a']
        }
    }
    val dp = Array(n + 1) { LongArray(m + 1) }
    dp[0][0] = 1
    for (i in 1..n) {
        dp[i][0] = 1
        for (j in 1..minOf(i, m)) {
            dp[i][j] = dp[i - 1][j]
            dp[i][j] += dp[i - 1][j - 1] * cnt[i - 1][j - 1]
            dp[i][j] %= modulo
        }
    }
    return dp[n][m].toInt()
}