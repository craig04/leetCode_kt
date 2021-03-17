package solution

import kotlin.math.abs

@Suppress("DEPRECATION")
fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
    return points.indices.filter {
        points[it][0] == x || points[it][1] == y
    }.minBy {
        abs(points[it][0] - x) + abs(points[it][1] - y)
    } ?: -1
}