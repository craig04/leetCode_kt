package cn_solution

import kotlin.math.abs

fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
    var pos = -1
    var dis = Int.MAX_VALUE
    for (i in points.indices) {
        val (a, b) = points[i]
        if (a == x || b == y) {
            val d = abs(a - x) + abs(b - y)
            if (d < dis) {
                pos = i
                dis = d
            }
        }
    }
    return pos
}