package cn_solution

import kotlin.math.absoluteValue
import kotlin.math.sign

fun baseNeg2(n: Int): String {
    val result = StringBuilder()
    var base = 1
    var temp = n
    do {
        val bit = temp and base.absoluteValue
        result.append(bit.sign)
        temp -= bit.sign * base
        base *= -2
    } while (temp != 0)
    return result.reverse().toString()
}