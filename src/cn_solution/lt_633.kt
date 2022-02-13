package cn_solution

import kotlin.math.floor
import kotlin.math.sqrt

fun judgeSquareSum(c: Int): Boolean {
    var low = 0
    var high = floor(sqrt(c.toDouble())).toInt()
    while (low <= high) {
        val t = low * low + high * high
        when {
            t < c -> low++
            t > c -> high--
            else -> return true
        }
    }
    return false
}