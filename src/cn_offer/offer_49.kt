package cn_offer

fun nthUglyNumber(n: Int): Int {
    val u = IntArray(n)
    u[0] = 1
    var p2 = 0
    var p3 = 0
    var p5 = 0
    for (i in 1 until n) {
        val n2 = 2 * u[p2]
        val n3 = 3 * u[p3]
        val n5 = 5 * u[p5]
        val next = minOf(n2, n3, n5)
        if (n2 == next) p2++
        if (n3 == next) p3++
        if (n5 == next) p5++
        u[i] = next
    }
    return u[n - 1]
}