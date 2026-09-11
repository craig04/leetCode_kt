package cn_solution

fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    fun pow(x: Int) = x * x
    val dx = maxOf(minOf(xCenter, x2), x1)
    val dy = maxOf(minOf(yCenter, y2), y1)
    return pow(dx - xCenter) + pow(dy - yCenter) <= pow(radius)
}