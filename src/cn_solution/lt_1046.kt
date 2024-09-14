package cn_solution

import java.util.*

fun lastStoneWeight(stones: IntArray): Int {
    val q = PriorityQueue<Int> { a, b -> b - a }
    q.addAll(stones.asList())
    while (q.size > 1) {
        val a = q.poll()
        val b = q.poll()
        if (a != b)
            q.offer(a - b)
    }
    return q.firstOrNull() ?: 0
}