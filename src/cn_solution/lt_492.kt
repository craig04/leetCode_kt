package cn_solution

import kotlin.math.ceil
import kotlin.math.sqrt

fun constructRectangle(area: Int): IntArray {
    val w = ceil(sqrt(area.toDouble())).toInt()
    return ((w downTo 1).firstOrNull { area % it == 0 } ?: 1).let {
        intArrayOf(area / it, it)
    }
}