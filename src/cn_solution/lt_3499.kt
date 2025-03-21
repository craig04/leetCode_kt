package cn_solution

fun maxActiveSectionsAfterTrade(s: String): Int {
    var origin = 0
    var change = 0
    var pre = Int.MIN_VALUE
    var cur = 0
    for (c in s) {
        if (c == '0') {
            cur++
            continue
        }
        origin++
        if (cur != 0) {
            change = maxOf(change, cur + pre)
            pre = cur
            cur = 0
        }
    }
    if (cur != 0)
        change = maxOf(change, cur + pre)
    return origin + change
}