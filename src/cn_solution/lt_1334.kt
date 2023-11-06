package cn_solution

fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    val infinity = Int.MAX_VALUE shr 1
    val dp = Array(n) { IntArray(n) { infinity } }
    edges.forEach { (u, v, w) ->
        dp[u][v] = w
        dp[v][u] = w
    }
    for (k in 0 until n) {
        dp[k][k] = 0
        for (i in 0 until n)
            for (j in 0 until n)
                dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j])
    }
    return dp.indices.reversed().minBy { i ->
        dp[i].count { it <= distanceThreshold }
    }
}