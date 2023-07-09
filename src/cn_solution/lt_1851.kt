package cn_solution

import java.util.*

fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
    val indices = queries.indices.sortedBy { queries[it] }
    val q = PriorityQueue<Int> { l, r ->
        val left = intervals[l]
        val right = intervals[r]
        left[1] - left[0] - right[1] + right[0]
    }
    var i = 0
    val result = IntArray(queries.size) { -1 }
    intervals.sortBy { it[0] }
    for (index in indices) {
        val query = queries[index]
        while (i != intervals.size && intervals[i][0] <= query)
            q.offer(i++)
        while (q.isNotEmpty()) {
            val itv = intervals[q.peek()]
            if (query in itv[0]..itv[1]) {
                result[index] = itv[1] - itv[0] + 1
                break
            }
            q.poll()
        }
    }
    return result
}