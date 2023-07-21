package cn_offer

fun maxProfit(prices: IntArray): Int {
    var lowest = Int.MAX_VALUE shr 1
    var profit = 0
    for (p in prices) {
        profit = maxOf(profit, p - lowest)
        lowest = minOf(lowest, p)
    }
    return profit
}