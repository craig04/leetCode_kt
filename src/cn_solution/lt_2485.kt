package cn_solution

import kotlin.math.sqrt

fun pivotInteger(n: Int): Int {
    val sq = n * (n + 1) / 2
    val root = sqrt(sq.toDouble()).toInt()
    return if (root * root == sq) root else -1
}