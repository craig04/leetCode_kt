package cn_solution

import java.util.*
import kotlin.math.sign

fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    val unit = DoubleArray(quality.size) { wage[it].toDouble() / quality[it] }
    val guard = 1000000000
    var total = guard.toLong() * k
    val q = PriorityQueue<Int> { l, r -> r - l }
    repeat(k) { q.offer(guard) }
    return quality.indices.sortedWith { l, r ->
        (unit[l] - unit[r]).sign.toInt()
    }.minOf {
        if (quality[it] < q.peek()) {
            total += quality[it] - q.poll()
            q.offer(quality[it])
            unit[it] * total
        } else {
            Double.MAX_VALUE
        }
    }
}