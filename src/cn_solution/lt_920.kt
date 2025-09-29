package cn_solution

fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
    val dp = LongArray(n + 1)
    dp[1] = n + 0L
    for (i in 2..goal) {
        for (j in n downTo 1) {
            val x = dp[j - 1] * (n - j + 1)
            val y = dp[j] * maxOf(j - k, 0)
            dp[j] = (x + y) % 1000000007
        }
    }
    return dp[n].toInt()
}