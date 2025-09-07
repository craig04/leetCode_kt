package cn_solution

fun getNoZeroIntegers(n: Int): IntArray {
    var a = 0
    var m = n
    var p = 1
    while (m >= 2) {
        var d = m % 10
        if (d <= 1) {
            d += 10
            m -= 10
        }
        a += d / 2 * p
        p *= 10
        m /= 10
    }
    return intArrayOf(a, n - a)
}