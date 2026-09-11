package cn_solution

import kotlin.math.abs

fun minRotations(n: Int, s: String): Int {
    fun distance(a: Char, b: Char): Int {
        val dist = abs(a - b)
        return minOf(dist, 10 - dist)
    }

    val end = s.last()
    var pre = '0'
    var ans = 0
    var opt = 0
    for (i in s.indices) {
        val dist = distance(s[i], pre)
        ans += dist
        opt = minOf(opt, distance(end, pre) - dist)
        pre = s[i]
    }
    return ans + opt
}