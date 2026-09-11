package cn_solution

fun minSkips(dist: IntArray, speed: Int, hoursBefore: Int): Int {
    val n = dist.size
    val dp = IntArray(n + 1) { Int.MAX_VALUE / 2 }
    dp[0] = 0
    for (i in 0 until n)
        for (j in i downTo 0) {
            dp[j] = (dp[j] + speed - 1) / speed * speed + dist[i]
            if (j != 0)
                dp[j] = minOf(dp[j], dp[j - 1] + dist[i])
        }
    return dp.indexOfFirst { it <= hoursBefore * 1L * speed }
}