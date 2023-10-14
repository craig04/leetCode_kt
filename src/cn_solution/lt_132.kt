package cn_solution

fun minCut(s: String): Int {
    val n = s.length
    val pal = Array(n) { BooleanArray(n) { true } }
    for (i in n - 1 downTo 0)
        for (j in i + 1 until n)
            pal[i][j] = pal[i + 1][j - 1] && s[i] == s[j]
    val dp = IntArray(n + 1)
    dp[0] = -1
    for (i in 1..n) {
        dp[i] = (0 until i).asSequence()
            .filter { pal[it][i - 1] }
            .minOf { dp[it] + 1 }
    }
    return dp[n]
}