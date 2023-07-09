package cn_solution

import java.util.*
import kotlin.math.abs

fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    val q = PriorityQueue<Int> { lhs, rhs ->
        val l = abs(lhs)
        val r = abs(rhs)
        val diff = costs[l] - costs[r]
        if (diff == 0) l - r else diff
    }
    var l = 0
    var r = costs.lastIndex
    while (l < minOf(candidates, r))
        q.add(l++)
    while (r >= maxOf(costs.size - candidates, l))
        q.add(-r--)
    var result = 0L
    repeat(k) {
        val w = q.poll()
        result += costs[abs(w)]
        if (l <= r)
            q.add(if (w >= 0) l++ else -r--)
    }
    return result
}