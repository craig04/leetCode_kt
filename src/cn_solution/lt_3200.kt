package cn_solution

import kotlin.math.sqrt

fun maxHeightOfTriangle(red: Int, blue: Int): Int {
    fun solve(a: Int, b: Int): Int {
        val odd = sqrt(a + 0.0).toInt()
        val even = ((sqrt(1 + 4.0 * b) - 1) / 2).toInt()
        return minOf(odd * 2, even * 2 + 1)
    }
    return maxOf(solve(red, blue), solve(blue, red))
}