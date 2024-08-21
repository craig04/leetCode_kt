package cn_solution

fun findMaximumNumber(k: Long, x: Int): Long {
    var l = 1L
    var r = 343778878348159L
    while (l != r) {
        val m = (r - l - 1).shr(1) + l + 1
        var price = 0L
        var group = 1L shl x
        while (group / 2 <= m) {
            val a = (m + 1) / group
            val b = (m + 1) % group
            price += a * (group / 2) + maxOf(0, b - group / 2)
            if (price > k)
                break
            group = group shl x
        }
        if (price <= k)
            l = m
        else
            r = m - 1
    }
    return l
}