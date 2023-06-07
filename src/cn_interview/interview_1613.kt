package cn_interview

import kotlin.math.abs

@Suppress("UnnecessaryVariable")
fun cutSquares(square1: IntArray, square2: IntArray): DoubleArray {
    val s1 = square1
    val s2 = square2
    val x1 = s1[0] + s1[2] * 0.5
    val y1 = s1[1] + s1[2] * 0.5
    val x2 = s2[0] + s2[2] * 0.5
    val y2 = s2[1] + s2[2] * 0.5
    val l = minOf(s1[0], s2[0]).toDouble()
    val b = minOf(s1[1], s2[1]).toDouble()
    val r = maxOf(s1[0] + s1[2], s2[0] + s2[2]).toDouble()
    val t = maxOf(s1[1] + s1[2], s2[1] + s2[2]).toDouble()
    if (x1 == x2) {
        return doubleArrayOf(x1, b, x2, t)
    }
    val ratio = (y1 - y2) / (x1 - x2)
    return if (abs(ratio) <= 1) {
        doubleArrayOf(l, (l - x1) * ratio + y1, r, (r - x2) * ratio + y2)
    } else if (ratio > 0) {
        doubleArrayOf((b - y1) / ratio + x1, b, (t - y2) / ratio + x2, t)
    } else {
        doubleArrayOf((t - y2) / ratio + x2, t, (b - y1) / ratio + x1, b)
    }
}