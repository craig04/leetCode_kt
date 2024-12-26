package cn_solution

import kotlin.math.absoluteValue

fun reachNumber(target: Int): Int {
    val pos = target.absoluteValue
    var num = 0
    var max = 0
    do {
        num++
        max += num
    } while (max < pos || (max - pos) % 2 != 0)
    return num
}