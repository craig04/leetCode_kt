package cn_solution

fun maxNiceDivisors(primeFactors: Int): Int {
    val modulo = 1000000007L
    var ans = 1L
    var cnt = primeFactors / 3
    var ext = maxOf(1, primeFactors % 3)
    if (primeFactors % 3 == 1 && primeFactors != 1) {
        cnt--
        ext = 4
    }
    var fac = 3L
    while (cnt != 0) {
        if (cnt and 1 == 1)
            ans = ans * fac % modulo
        fac = fac * fac % modulo
        cnt = cnt shr 1
    }
    return (ans * ext % modulo).toInt()
}