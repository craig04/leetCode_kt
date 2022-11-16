package cn_solution

fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val n = startTime.size
    val jobs = Array(n) { intArrayOf(startTime[it], endTime[it], profit[it]) }
    jobs.sortBy { it[1] }
    val dp = IntArray(n + 1)
    for (i in 0 until n) {
        var l = 0
        var r = i
        while (l != r) {
            val m = (l + r + 1) shr 1
            when {
                jobs[m - 1][1] <= jobs[i][0] -> l = m
                else -> r = m - 1
            }
        }
        dp[i + 1] = maxOf(dp[i], dp[l] + jobs[i][2])
    }
    return dp[n]
}
