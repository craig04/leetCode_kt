package cn_solution

fun generateMatrix(n: Int): Array<IntArray> {
    val m = Array(n) { IntArray(n) }
    var k = 0
    val h = n / 2
    for (i in 0 until h) {
        for (t in i until n - i - 1)
            m[i][t] = ++k
        for (t in i until n - i - 1)
            m[t][n - 1 - i] = ++k
        for (t in n - 1 - i downTo i + 1)
            m[n - 1 - i][t] = ++k
        for (t in n - 1 - i downTo i + 1) {
            m[t][i] = ++k
        }
    }
    if (n % 2 == 1) {
        m[h][h] = ++k
    }
    return m
}