package cn_solution

import kotlin.math.abs
import kotlin.math.pow

fun closestDivisors(num: Int): IntArray {
    fun divisors(x: Int): IntArray {
        val r = x.toDouble().pow(0.5).toInt()
        val a = (r downTo 1).first { x % it == 0 }
        return intArrayOf(a, x / a)
    }

    val x = divisors(num + 1)
    val y = divisors(num + 2)
    return if (abs(x[0] - x[1]) < abs(y[0] - y[1])) x else y
}