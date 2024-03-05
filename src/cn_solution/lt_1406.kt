package cn_solution

fun stoneGameIII(stoneValue: IntArray): String {
    val n = stoneValue.size
    val dp = IntArray(n + 1)
    dp[n] = 0
    for (i in n - 1 downTo 0) {
        var diff = 0
        dp[i] = (i until minOf(i + 3, n)).maxOf {
            diff += stoneValue[it]
            diff - dp[it + 1]
        }
    }
    return when {
        dp[0] > 0 -> "Alice"
        dp[0] < 0 -> "Bob"
        else -> "Tie"
    }
}