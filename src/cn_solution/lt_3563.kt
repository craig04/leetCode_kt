package cn_solution

import kotlin.math.abs

fun lexicographicallySmallestString(s: String): String {
    fun adjacent(i: Int, j: Int): Boolean {
        val dist = abs(s[i] - s[j])
        return dist == 1 || dist == 25
    }

    val n = s.length
    val f = Array(n + 1) { BooleanArray(n + 1) }
    for (i in n downTo 0) {
        f[i][i] = true
        for (j in i + 2..n step 2) {
            if (f[i + 1][j - 1] && adjacent(i, j - 1)) {
                f[i][j] = true
                continue
            }
            for (k in i + 2 until n step 2)
                if (f[i][k] && f[k][j]) {
                    f[i][j] = true
                    break
                }
        }
    }
    val g = Array(n + 1) { "" }
    for (i in n - 1 downTo 0) {
        g[i] = s[i] + g[i + 1]
        for (j in i + 2..n step 2)
            if (f[i][j])
                g[i] = minOf(g[i], g[j])
    }
    return g[0]
}