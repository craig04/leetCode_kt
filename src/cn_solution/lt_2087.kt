package cn_solution

fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
    val (sx, sy) = startPos
    val (hx, hy) = homePos
    val u = minOf(sx, hx)
    val d = maxOf(sx, hx)
    val l = minOf(sy, hy)
    val r = maxOf(sy, hy)
    return (u..d).sumOf { rowCosts[it] } +
            (l..r).sumOf { colCosts[it] } -
            rowCosts[sx] - colCosts[sy]
}