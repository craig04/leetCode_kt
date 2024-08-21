package cn_solution

fun minimumCoins(prices: IntArray): Int {
    val n = prices.size
    val dp = IntArray(n + 1)
    val q = ArrayDeque<Int>()
    q.add(n)
    for (i in prices.indices.reversed()) {
        val j = i * 2 + 2
        while (q.last() > j)
            q.removeLast()
        dp[i] = prices[i] + dp[q.last()]
        while (q.isNotEmpty() && dp[i] <= dp[q.first()])
            q.removeFirst()
        q.addFirst(i)
    }
    return dp[0]
}