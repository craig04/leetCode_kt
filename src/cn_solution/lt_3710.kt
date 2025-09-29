package cn_solution

import kotlin.math.abs

fun maxPartitionFactor(points: Array<IntArray>): Int {
    val n = points.size
    if (n == 2)
        return 0
    var l = 0
    var r = 0
    for (i in 0 until n) {
        val (x, y) = points[i]
        for (j in i + 1 until n) {
            val (p, q) = points[j]
            r = maxOf(r, abs(p - x) + abs(q - y))
        }
    }
    while (l != r) {
        val colors = IntArray(n)
        val m = (l + r + 1) shr 1
        fun dfs(u: Int, c: Int): Boolean {
            val (x, y) = points[u]
            colors[u] = c
            for (v in 0 until n) {
                if (u == v)
                    continue
                val (p, q) = points[v]
                if (abs(p - x) + abs(q - y) >= m)
                    continue
                if (colors[v] == c || colors[v] == 0 && !dfs(v, -c))
                    return false
            }
            return true
        }
        if ((0 until n).all { colors[it] != 0 || dfs(it, 1) })
            l = m
        else
            r = m - 1
    }
    return l
}