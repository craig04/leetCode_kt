package cn_solution

import java.util.*

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val q = PriorityQueue<Int> { l, r -> r - l }
    var i = 0
    var c = w
    val indices = profits.indices.sortedBy { capital[it] }
    for (x in 0 until k) {
        while (i != indices.size && capital[indices[i]] <= c)
            q.add(profits[indices[i++]])
        c += q.poll() ?: break
    }
    return c
}