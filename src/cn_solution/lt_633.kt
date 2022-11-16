package cn_solution

import kotlin.math.floor
import kotlin.math.sqrt

fun judgeSquareSum(c: Int): Boolean {
    val r = floor(sqrt(c.toDouble())).toInt()
    var low = 0
    var high = r
    while (low <= high) {
        val a = c - high * high
        val b = low * low
        when {
            a > b -> low++
            a < b -> high--
            else -> return true
        }
    }
    return false
}
