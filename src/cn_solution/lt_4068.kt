package cn_solution

fun maxEarnings(meetings: Array<IntArray>): Long {
    meetings.sortBy { it[1] }
    val dp = LongArray(meetings.size + 1) { Long.MIN_VALUE }
    return meetings.indices.maxOf { j ->
        val (s, e, revenue) = meetings[j]
        var l = -1
        var r = j
        while (l != r) {
            val m = (l + r + 1) / 2
            if (meetings[m][1] <= s)
                l = m
            else
                r = m - 1
        }
        var res = 0L + revenue
        if (l != -1)
            res += dp[l + 1] + s
        dp[j + 1] = maxOf(dp[j], res - e)
        res
    }
}