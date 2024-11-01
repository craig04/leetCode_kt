package cn_solution

import kotlin.math.sign
import kotlin.math.sqrt

fun judgeSquareSum(c: Int): Boolean {
    var a = 0
    var b = sqrt(c.toDouble()).toInt()
    while (a <= b) {
        when ((c - a * a - b * b).sign) {
            0 -> return true
            1 -> a++
            else -> b--
        }
    }
    return false
}