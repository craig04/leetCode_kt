package cn_solution

import kotlin.math.ceil

fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
    val ceil = ceil(hour).toInt()
    if (dist.size > ceil)
        return -1
    var l = 1
    var r = dist.max()!!
    if (dist.size == ceil) {
        r = maxOf(r, ceil(dist.last() / (hour + 1 - dist.size)).toInt())
    }
    fun arrive(speed: Double) = (0 until dist.lastIndex).sumByDouble { ceil(dist[it] / speed) } + dist.last() / speed <= hour
    while (l != r) {
        val m = (l + r) shr 1
        when (arrive(m.toDouble())) {
            true -> r = m
            else -> l = m + 1
        }
    }
    return r
}