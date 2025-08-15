package cn_solution

import kotlin.math.pow

fun smallestGoodBase(n: String): String {
    val num = n.toLong()
    for (len in (64 - num.countLeadingZeroBits()) downTo 2) {
        val x = (num + 0.0).pow(1.0 / (len - 1)).toInt()
        var pow = 1L
        var sum = 1L
        for (i in 1 until len) {
            pow *= x
            sum += pow
        }
        if (sum == num)
            return x.toString()
    }
    return (num - 1).toString()
}