package cn_solution

fun mostPoints(questions: Array<IntArray>): Long {
    val n = questions.size
    val dp = LongArray(n + 1)
    for (i in questions.indices.reversed()) {
        val (p, b) = questions[i]
        dp[i] = maxOf(dp[i + 1], p + dp[minOf(i + b + 1, n)])
    }
    return dp[0]
}