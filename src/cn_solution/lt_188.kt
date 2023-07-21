package cn_solution

fun maxProfit(k: Int, prices: IntArray): Int {
    val cnt = minOf(k, prices.size / 2)
    val b = IntArray(cnt + 1) { Int.MIN_VALUE }
    val s = IntArray(cnt + 1)
    for (p in prices) {
        for (i in 1..cnt) {
            b[i] = maxOf(b[i], s[i - 1] - p)
            s[i] = maxOf(s[i], b[i] + p)
        }
    }
    return s[cnt]
}