package cn_solution

import kotlin.math.abs

fun maxDistance(s: String, k: Int): Int {
    var x = 0
    var y = 0
    return s.indices.maxOf { i ->
        when (s[i]) {
            'W' -> x--
            'E' -> x++
            'S' -> y--
            'N' -> y++
        }
        minOf(abs(x) + abs(y) + 2 * k, i + 1)
    }
}