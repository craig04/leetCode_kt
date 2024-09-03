package cn_solution

fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val dp = IntArray(days.size + 1)
    val gap = intArrayOf(1, 7, 30)
    for (i in days.lastIndex downTo 0) {
        dp[i] = Int.MAX_VALUE
        var j = i + 1
        for (t in gap.indices) {
            while (j < days.size && days[j] - days[i] < gap[t])
                j++
            dp[i] = minOf(dp[i], dp[j] + costs[t])
        }
    }
    return dp[0]
}