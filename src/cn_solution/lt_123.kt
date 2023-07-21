package cn_solution

private fun maxProfit(prices: IntArray): Int {
    var b1 = Int.MIN_VALUE
    var s1 = 0
    var b2 = Int.MIN_VALUE
    var s2 = 0
    for (p in prices) {
        b1 = maxOf(b1, -p)
        s1 = maxOf(s1, p + b1)
        b2 = maxOf(b2, -p + s1)
        s2 = maxOf(s2, p + b2)
    }
    return s2
}