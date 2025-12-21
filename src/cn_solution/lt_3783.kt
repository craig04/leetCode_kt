package cn_solution

import kotlin.math.abs

fun mirrorDistance(n: Int): Int {
    var m = n
    var r = 0
    while (m != 0) {
        r = r * 10 + m % 10
        m /= 10
    }
    return abs(n - r)
}