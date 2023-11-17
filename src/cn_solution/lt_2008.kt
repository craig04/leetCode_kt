package cn_solution

fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
    val dp = LongArray(n + 1)
    rides.sortBy { it[1] }
    var j = 0
    for (i in 1..n) {
        dp[i] = dp[i - 1]
        while (j != rides.size && rides[j][1] == i) {
            val (s, e, t) = rides[j++]
            dp[i] = maxOf(dp[i], dp[s] + t + e - s)
        }
    }
    return dp[n]
}