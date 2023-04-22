package cn_solution

fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    return (1 until points.size).fold(0) { acc, i ->
        maxOf(acc, points[i][0] - points[i - 1][0])
    }
}