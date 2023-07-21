package cn_solution

import kotlin.math.pow

fun repairCars(ranks: IntArray, cars: Int): Long {
    var l = 0L
    var r = ranks[0].toLong() * cars * cars
    while (l != r) {
        val m = (l + r) shr 1
        if (ranks.sumOf { (m / it * 1.0).pow(0.5).toLong() } < cars)
            l = m + 1
        else
            r = m
    }
    return r
}