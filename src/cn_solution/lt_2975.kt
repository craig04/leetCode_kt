package cn_solution

import kotlin.math.abs

fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
    fun distances(a: IntArray, x: Int): HashSet<Int> {
        val res = hashSetOf(x - 1)
        for (i in a.indices) {
            res += a[i] - 1
            res += x - a[i]
            for (j in i + 1 until a.size)
                res += abs(a[j] - a[i])
        }
        return res
    }

    val hor = distances(hFences, m)
    val ver = distances(vFences, n)
    val len = hor.maxOf { if (it in ver) it else 0 }
    return if (len == 0) -1 else (1L * len * len).mod(1000_000_007)
}