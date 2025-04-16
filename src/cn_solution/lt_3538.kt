package cn_solution

fun minTravelTime(l: Int, n: Int, k: Int, position: IntArray, time: IntArray): Int {
    val m = n - k
    val pre = IntArray(n + 1)
    for (i in 0 until n)
        pre[i + 1] = pre[i] + time[i]
    val dp = Array(n) { Array(n) { IntArray(m + 1) { Int.MAX_VALUE / 2 } } }
    for (i in 1 until n)
        dp[i][n - 1][1] = 0
    for (i in n - 2 downTo 0)
        for (j in i until n - 1) {
            val time = pre[j + 1] - pre[i]
            for (t in 2..m)
                for (p in j + 1 until n) {
                    val cost = (position[p] - position[j]) * time
                    dp[i][j][t] = minOf(dp[i][j][t], dp[j + 1][p][t - 1] + cost)
                }
        }
    return dp[0][0][m]
}