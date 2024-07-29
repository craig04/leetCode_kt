package cn_solution

import kotlin.math.abs

fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
    val min = IntArray(26) { Int.MAX_VALUE }
    var dia = Int.MAX_VALUE
    for (i in s.indices) {
        val idx = s[i] - 'a'
        val pts = points[i]
        val len = maxOf(abs(pts[0]), abs(pts[1]))
        dia = minOf(dia, maxOf(len, min[idx]))
        min[idx] = minOf(min[idx], len)
    }
    return points.count { (x, y) -> maxOf(abs(x), abs(y)) < dia }
}