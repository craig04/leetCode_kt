package cn_solution

fun countGoodNumbers(n: Long): Int {
    val modulo = 1000000007
    fun pow(a: Long, x: Long): Long {
        var r = 1L
        var p = a
        var y = x
        while (y != 0L) {
            if (y and 1 == 1L)
                r = (r * p) % modulo
            p = (p * p) % modulo
            y = y shr 1
        }
        return r
    }
    return (pow(5, (n + 1) / 2) * pow(4, n / 2)).mod(modulo)
}