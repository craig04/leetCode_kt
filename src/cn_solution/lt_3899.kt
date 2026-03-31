package cn_solution

import kotlin.math.PI
import kotlin.math.acos

fun internalAngles(sides: IntArray): DoubleArray {
    sides.sort()
    val (a, b, c) = sides
    if (a + b < c)
        return DoubleArray(0)
    val r = 180.0 / PI
    val y = acos((a * a + c * c - b * b) / (2.0 * a * c)) * r
    val z = acos((a * a + b * b - c * c) / (2.0 * a * b)) * r
    return doubleArrayOf(180 - y - z, y, z)
}