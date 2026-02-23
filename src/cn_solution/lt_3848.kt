package cn_solution

fun isDigitorialPermutation(n: Int): Boolean {
    val f = IntArray(10)
    val d = IntArray(10)
    f[0] = 1
    for (i in 1..9)
        f[i] = f[i - 1] * i
    var m = n
    var s = 0
    while (m != 0) {
        val rem = m % 10
        d[rem]++
        s += f[rem]
        m /= 10
    }
    while (s != 0) {
        d[s % 10]--
        s /= 10
    }
    return d.all { it == 0 }
}