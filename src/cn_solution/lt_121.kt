package cn_solution

private fun maxProfit(prices: IntArray): Int {
    var min = prices[0]
    var result = 0
    for (p in prices) {
        min = min.coerceAtMost(p)
        result = result.coerceAtLeast(p - min)
    }
    return result
}