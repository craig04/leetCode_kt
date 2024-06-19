package cn_solution

fun minDistance(houses: IntArray, k: Int): Int {
    houses.sort()
    val n = houses.size
    val cost = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        cost[i][i] = 0
        for (j in i + 1 until n) {
            cost[i][j] = cost[i][j - 1] + houses[j] - houses[(j + i) shr 1]
        }
    }
    val dp = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
        dp[i][1] = cost[0][i - 1]
        for (j in 2..minOf(i, k)) {
            dp[i][j] = (j - 1 until i).minOf {
                dp[it][j - 1] + cost[it][i - 1]
            }
        }
    }
    return dp[n][k]
}