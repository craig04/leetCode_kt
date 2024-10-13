package cn_solution

import kotlin.math.ceil
import kotlin.math.sqrt

fun twoEggDrop(n: Int): Int {
    return ceil((sqrt(8 * n + 1.0) - 1) / 2).toInt()
}