package cn_solution

fun countGoodStrings(n: Long): Int {
    val modulo = 1000000007
    operator fun LongArray.timesAssign(that: LongArray) {
        val (a, b, c, d) = this
        val (x, y, z, w) = that
        this[0] = (a * x + b * z) % modulo
        this[1] = (a * y + b * w) % modulo
        this[2] = (c * x + d * z) % modulo
        this[3] = (c * y + d * w) % modulo
    }

    val mat = longArrayOf(1, 1, 1, 0)
    val pow = longArrayOf(2, 0, 0, 2)
    var m = n - 1
    while (m != 0L) {
        if (m and 1 == 1L)
            pow *= mat
        mat *= mat
        m = m shr 1
    }
    return pow[0].toInt()
}