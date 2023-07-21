package cn_solution

private const val INF = Int.MAX_VALUE shr 1

fun connectTwoGroups(cost: List<List<Int>>): Int {
    val n = cost.size
    val m = cost[0].size
    val stat = 1 shl m
    val dp = Array(n + 1) { IntArray(stat) { INF } }
    dp[0][0] = 0
    for (i in 1..n)
        for (s in 1 until stat)
            for (k in 0 until m) {
                if (1.shl(k).and(s) == 0)
                    continue
                val prev = 1.shl(k).xor(s)
                val temp = minOf(dp[i][prev], dp[i - 1][s], dp[i - 1][prev])
                dp[i][s] = minOf(dp[i][s], temp + cost[i - 1][k])
            }
    return dp[n][stat - 1]
}