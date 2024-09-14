package cn_solution

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val dp = Array(k + 2) { IntArray(n) { Int.MAX_VALUE / 2 } }
    dp[0][src] = 0
    for (i in 1..k + 1)
        for ((u, v, p) in flights)
            dp[i][v] = minOf(dp[i][v], dp[i - 1][u] + p)
    val ans = dp.minOf { it[dst] }
    return if (ans == Int.MAX_VALUE / 2) -1 else ans
}