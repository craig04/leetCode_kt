package cn_solution

import java.util.*

fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    val q = PriorityQueue<Int> { a, b -> b - a }
    var last = 0
    var fuel = startFuel
    var count = 0
    for (i in 0..stations.size) {
        val s = if (i in stations.indices) stations[i] else null
        val cur = s?.let { it[0] } ?: target
        fuel -= (cur - last)
        last = cur
        while (fuel < 0) {
            if (q.isEmpty()) return -1
            count++
            fuel += q.poll()
        }
        s?.also { q.offer(it[1]) }
    }
    return count
}