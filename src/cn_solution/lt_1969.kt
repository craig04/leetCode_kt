package cn_solution

fun minNonZeroProduct(p: Int): Int {
    val modulo = 1000000007
    var times = 1L.shl(p - 1) - 1
    var x = (1L.shl(p) - 2) % modulo
    var result = x + 1
    while (times != 0L) {
        if (times and 1 != 0L)
            result = (result * x) % modulo
        times = times shr 1
        x = (x * x) % modulo
    }
    return result.toInt()
}