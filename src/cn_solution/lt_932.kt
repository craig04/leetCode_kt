package cn_solution

fun beautifulArray(n: Int): IntArray {
    val dp = Array(n + 1) { IntArray(it) }
    dp[1][0] = 1
    for (len in 2..n) {
        val left = len / 2
        for (j in 0 until left)
            dp[len][j] = dp[left][j] * 2
        val right = len - left
        for (j in 0 until right)
            dp[len][left + j] = dp[right][j] * 2 - 1
    }
    return dp[n]
}