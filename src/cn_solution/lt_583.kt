package cn_solution

/**
 * O(n) space complexity
 */
fun minDistance(word1: String, word2: String): Int {
    val n = word1.length
    val m = word2.length
    val dp = IntArray(m + 1) { it }
    for (i in 1..n) {
        var last = dp[0]
        dp[0] = i
        for (j in 1..m) {
            val temp = if (word1[i - 1] == word2[j - 1])
                last
            else
                minOf(dp[j], dp[j - 1]) + 1
            last = dp[j]
            dp[j] = temp
        }
    }
    return dp[m]
}

/**
 * O(n*n) space complexity
 */
fun minDistance_traditional(word1: String, word2: String): Int {
    val n = word1.length
    val m = word2.length
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) dp[i][0] = i
    for (j in 1..m) dp[0][j] = j
    for (i in 1..n)
        for (j in 1..m) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + 1
            }
        }
    return dp[n][m]
}
