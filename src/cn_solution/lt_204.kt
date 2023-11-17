package cn_solution

fun countPrimes(n: Int): Int {
    var result = 0
    val f = BooleanArray(n)
    for (i in 2 until n)
        if (!f[i]) {
            result++
            for (j in i + i until n step i)
                f[j] = true
        }
    return result
}