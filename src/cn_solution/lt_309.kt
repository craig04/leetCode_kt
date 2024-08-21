package cn_solution

private fun maxProfit(prices: IntArray): Int {
    var a = Int.MIN_VALUE
    var b = 0
    var c = 0
    for (price in prices) {
        val x = maxOf(a, c - price)
        val y = a + price
        val z = maxOf(b, c)
        a = x
        b = y
        c = z
    }
    return maxOf(a, b, c)
}