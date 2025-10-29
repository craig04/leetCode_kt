package cn_solution

fun removeZeros(n: Long): Long {
    var pow = 1L
    var ans = 0L
    var m = n
    while (m != 0L) {
        val d = m % 10
        if (d != 0L) {
            ans += d * pow
            pow *= 10
        }
        m /= 10
    }
    return ans
}