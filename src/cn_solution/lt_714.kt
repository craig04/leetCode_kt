package cn_solution

fun maxProfit(prices: IntArray, fee: Int): Int {
    var profit = 0
    var cost = Int.MAX_VALUE
    for (p in prices) {
        if (cost > p + fee) {
            cost = p + fee
        } else if (cost < p) {
            profit += p - cost
            cost = p
        }
    }
    return profit
}