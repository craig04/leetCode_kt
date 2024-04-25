package cn_solution

fun maxValue(events: Array<IntArray>, k: Int): Int {
    events.sortBy { it[1] }
    val dp = Array(events.size + 1) { IntArray(k + 1) }
    for (i in events.indices) {
        val (start, _, value) = events[i]
        var l = -1
        var r = i - 1
        while (l != r) {
            val m = (l + r + 1) shr 1
            if (events[m][1] < start)
                l = m
            else
                r = m - 1
        }
        for (j in 1..k)
            dp[i + 1][j] = maxOf(dp[i][j], dp[l + 1][j - 1] + value)
    }
    return dp[events.size][k]
}