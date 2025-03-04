package cn_solution

fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    val (a, b, c, d) = rec1
    val (x, y, z, w) = rec2
    return !(a >= z || c <= x || b >= w || d <= y)
}