package cn_solution

fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
    val profit = IntArray(prices.size) { prices[it] * strategy[it] }
    val ans = profit.fold(0L, Long::plus)
    var cur = (0 until k / 2).fold(0L) { res, i ->
        val j = i + k / 2
        res + prices[j] - profit[j] - profit[i]
    }
    val max = (k until prices.size).fold(cur) { res, r ->
        cur += profit[r - k] - prices[r - k / 2] + prices[r] - profit[r]
        maxOf(res, cur)
    }
    return ans + maxOf(max, 0)
}