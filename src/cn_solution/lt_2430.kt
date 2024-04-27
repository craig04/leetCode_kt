package cn_solution

fun deleteString(s: String): Int {
    val modulo = 1000003
    val n = s.length
    val hash = Array(n) { IntArray(n + 1) }
    for (i in 0 until n) {
        var h = 0
        for (j in i until n) {
            h = (s[j] - 'a' + h * 31) % modulo
            hash[i][j + 1] = h
        }
    }
    val dp = IntArray(n + 1)
    for (i in s.indices.reversed()) {
        dp[i] = (i + 2..n step 2).fold(1) { acc, k ->
            val j = (k + i) shr 1
            maxOf(if (hash[i][j] == hash[j][k]) dp[j] + 1 else 0, acc)
        }
    }
    return dp[0]
}