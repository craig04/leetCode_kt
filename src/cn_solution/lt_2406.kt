package cn_solution

fun minGroups(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[0] }
    val pq = java.util.PriorityQueue<Int>()
    intervals.mapTo(pq) { (l, r) ->
        if (pq.isNotEmpty() && pq.peek() < l)
            pq.poll()
        r
    }
    return pq.size
}