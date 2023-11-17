package cn_lcr

fun mySqrt(x: Int): Int {
    var l = 0
    var r = x
    var result = 0
    while (l <= r) {
        val m = (l + r) shr 1
        val sqr = m * m.toLong()
        if (sqr <= x) {
            result = m
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return result
}