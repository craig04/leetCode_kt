package cn_solution

fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    val x1 = maxOf(ax1, bx1)
    val x2 = minOf(ax2, bx2)
    val y1 = maxOf(ay1, by1)
    val y2 = minOf(ay2, by2)
    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - maxOf(0, x2 - x1) * maxOf(0, y2 - y1)
}