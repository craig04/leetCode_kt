package cn_solution

fun getDescentPeriods(prices: IntArray): Long {
    var len = 1L
    return 1L + (1 until prices.size).sumOf {
        if (prices[it] != prices[it - 1] - 1)
            len = 0
        ++len
    }
}