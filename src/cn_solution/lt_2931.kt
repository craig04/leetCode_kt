package cn_solution

import java.util.*

fun maxSpending(values: Array<IntArray>): Long {
    val n = values.size
    val m = values[0].size
    var day = n * m.toLong()
    val pos = IntArray(n)
    val q = PriorityQueue<Int> { l, r -> values[r][pos[r]] - values[l][pos[l]] }
    q.addAll(values.indices)
    var result = 0L
    while (q.isNotEmpty()) {
        val t = q.poll()
        result += values[t][pos[t]] * day--
        if (++pos[t] != m)
            q.offer(t)
    }
    return result
}