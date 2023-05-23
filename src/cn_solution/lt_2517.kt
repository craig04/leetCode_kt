package cn_solution

fun maximumTastiness(price: IntArray, k: Int): Int {
    if (price.size < k)
        return 0
    price.sort()
    var l = 0
    var r = price.last() - price.first()
    while (l != r) {
        val m = (l + r + 1) shr 1
        var count = 1
        var last = price[0]
        for (p in price) {
            if (p - last >= m) {
                count++
                last = p
            }
        }
        when (count >= k) {
            true -> l = m
            else -> r = m - 1
        }
    }
    return l
}