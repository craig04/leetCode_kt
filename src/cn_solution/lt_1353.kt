package cn_solution

import java.util.PriorityQueue

fun maxEvents(events: Array<IntArray>): Int {
    events.sortBy { it[0] }
    val q = PriorityQueue<Int> { l, r -> events[l][1] - events[r][1] }
    var i = 0
    var cur = events[0][0]
    var ans = 0
    while (i != events.size || q.isNotEmpty()) {
        while (i != events.size && events[i][0] == cur)
            q.offer(i++)
        while (q.isNotEmpty())
            if (events[q.poll()][1] >= cur) {
                ans++
                break
            }
        if (q.isNotEmpty())
            cur++
        else if (i != events.size)
            cur = events[i][0]
    }
    return ans
}