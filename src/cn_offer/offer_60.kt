package cn_offer

import kotlin.math.max

fun dicesProbability(n: Int): DoubleArray {
    val count = IntArray(6 * n + 1)
    count[0] = 1
    for (i in 1..n)
        for (j in 6 * i downTo 0)
            count[j] = (max(0, j - 6) until j).sumBy { count[it] }
    val total = count.sum().toDouble()
    return DoubleArray(5 * n + 1) { count[it + n] / total }
}