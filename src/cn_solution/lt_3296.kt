package cn_solution

import kotlin.math.floor
import kotlin.math.sqrt

fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
    var l = 1L
    var r = (1L + mountainHeight) * mountainHeight / 2L * workerTimes.min()
    while (l != r) {
        val m = (l + r) shr 1
        val x = m * 8.0
        val height = workerTimes.sumOf { floor((sqrt(1 + x / it) - 1) / 2).toInt() }
        if (height >= mountainHeight)
            r = m
        else
            l = m + 1
    }
    return l
}