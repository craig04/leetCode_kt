package cn_solution

private fun maxProfit(prices: IntArray): Int {
    return (1 until prices.size).sumBy { maxOf(0, prices[it] - prices[it - 1]) }
}