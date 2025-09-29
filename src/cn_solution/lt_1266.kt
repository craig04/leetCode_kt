package cn_solution

import kotlin.math.abs

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    return (1 until points.size).sumOf { i ->
        val (x, y) = points[i]
        val (a, b) = points[i - 1]
        maxOf(abs(x - a), abs(y - b))
    }
}