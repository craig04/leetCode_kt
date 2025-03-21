package cn_solution

import kotlin.math.abs

fun findClosest(x: Int, y: Int, z: Int): Int {
    val a = abs(x - z)
    val b = abs(y - z)
    return when {
        a < b -> 1
        a > b -> 2
        else -> 0
    }
}