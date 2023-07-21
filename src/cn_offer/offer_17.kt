package cn_offer

import kotlin.math.pow

fun printNumbers(n: Int): IntArray {
    return IntArray(10.0.pow(n.toDouble()).toInt() - 1) { it + 1 }
}