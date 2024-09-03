package cn_solution

fun countTexts(pressedKeys: String): Int {
    val len = intArrayOf(3, 3, 3, 3, 3, 4, 3, 4)
    val modulo = 1000000007
    val n = pressedKeys.length
    val dp = IntArray(n + 1)
    dp[n] = 1
    for (i in pressedKeys.indices.reversed()) {
        val key = pressedKeys[i] - '2'
        var j = i
        while (j < n && j - i < len[key] && pressedKeys[i] == pressedKeys[j])
            dp[i] = (dp[i] + dp[++j]) % modulo
    }
    return dp[0]
}