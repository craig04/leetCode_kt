package solution_cn

fun isBoomerang(points: Array<IntArray>): Boolean {
    val y1 = points[2][1] - points[1][1]
    val y0 = points[1][1] - points[0][1]
    val x1 = points[2][0] - points[1][0]
    val x0 = points[1][0] - points[0][0]
    return y1 * x0 != y0 * x1
}