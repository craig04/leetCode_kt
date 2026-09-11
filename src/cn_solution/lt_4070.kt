package cn_solution

import kotlin.math.abs

fun minRotations(s: String): Int {
    var pre = '0'
    return s.sumOf { cur ->
        val dis = abs(cur - pre)
        pre = cur
        minOf(dis, 10 - dis)
    }
}