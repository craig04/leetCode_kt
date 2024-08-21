package cn_solution

import java.util.*
import kotlin.math.abs

fun resultsArray(queries: Array<IntArray>, k: Int): IntArray {
    val q = PriorityQueue<Int> { l, r -> r - l }
    return IntArray(queries.size) {
        val (x, y) = queries[it]
        q.add(abs(x) + abs(y))
        if (q.size > k)
            q.poll()
        if (q.size < k)
            -1
        else
            q.first()
    }
}