package cn_solution

import kotlin.math.abs

fun angleClock(hour: Int, minutes: Int): Double {
    val ans = abs(hour * 30 - minutes * 5.5)
    return minOf(ans, 360 - ans)
}