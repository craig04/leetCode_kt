package cn_solution

private fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
    val modulo = 1000000007
    val a = Array(zero + 1) { LongArray(one + 1) }
    val b = Array(zero + 1) { LongArray(one + 1) }
    for (i in 1..minOf(zero, limit))
        a[i][0] = 1
    for (j in 1..minOf(one, limit))
        b[0][j] = 1
    for (i in 1..zero)
        for (j in 1..one) {
            a[i][j] = (a[i - 1][j] + b[i - 1][j] + modulo - if (i > limit) b[i - limit - 1][j] else 0) % modulo
            b[i][j] = (a[i][j - 1] + b[i][j - 1] + modulo - if (j > limit) a[i][j - limit - 1] else 0) % modulo
        }
    return (a[zero][one] + b[zero][one]).mod(modulo)
}