package cn_solution

import kotlin.math.abs

fun findMinMoves(machines: IntArray): Int {
    val sum = machines.sum()
    if (sum % machines.size != 0)
        return -1
    val avg = sum / machines.size
    var tmp = 0
    return machines.indices.maxOf {
        tmp += machines[it] - avg
        maxOf(abs(tmp), machines[it] - avg)
    }
}