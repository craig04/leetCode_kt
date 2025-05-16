package cn_solution

fun maximumProfit(prices: IntArray, k: Int): Long {
    val n = prices.size
    var a = Array(k + 2) { LongArray(3) { Long.MIN_VALUE / 2 } }
    var b = Array(k + 2) { LongArray(3) { Long.MIN_VALUE / 2 } }
    for (j in 1..k + 1)
        a[j][0] = 0
    for (i in 1..n) {
        for (j in 1..k + 1) {
            b[j][0] = maxOf(a[j][0], a[j - 1][1] + prices[i - 1], a[j - 1][2] - prices[i - 1])
            b[j][1] = maxOf(a[j][1], a[j][0] - prices[i - 1])
            b[j][2] = maxOf(a[j][2], a[j][0] + prices[i - 1])
        }
        val c = a
        a = b
        b = c
    }
    return a[k + 1][0]
}