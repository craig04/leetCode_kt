package cn_solution

import java.util.*

fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    meetings.sortBy { it[0] }
    val free = (0 until n).mapTo(PriorityQueue()) { it }
    val using = PriorityQueue<Pair<Long, Int>>(
        compareBy({ it.first }, { it.second })
    )
    val count = IntArray(n)
    for ((s, e) in meetings) {
        while (using.isNotEmpty() && using.peek().first <= s)
            free.offer(using.poll().second)
        if (free.isEmpty()) {
            val (t, idx) = using.poll()
            count[idx]++
            using.offer(Pair(t + e - s, idx))
        } else {
            val idx = free.poll()
            count[idx]++
            using.offer(Pair(e.toLong(), idx))
        }
    }
    return count.indices.maxBy { count[it] }
}