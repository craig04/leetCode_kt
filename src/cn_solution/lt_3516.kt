package cn_solution

import kotlin.math.abs

fun findClosest(x: Int, y: Int, z: Int): Int {
    val t = abs(x - z).compareTo(abs(y - z))
    return if (t == 0) 0 else if (t == -1) 1 else 2
}