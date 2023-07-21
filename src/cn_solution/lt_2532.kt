package cn_solution

import java.util.*

const val BOX_FETCHED = 0
const val BOX_PUT = 1
const val RIGHT_ARRIVED = 2
const val LEFT_ARRIVED = 3

@Suppress("CascadeIf")
fun findCrossingTime(n: Int, k: Int, time: Array<IntArray>): Int {
    val comp: (Int, Int) -> Int = { l, r ->
        val diff = time[r][0] + time[r][2] - time[l][0] - time[l][2]
        if (diff == 0) r - l else diff
    }
    var result = 0
    var remain = n
    var current = 0
    var crossing = false
    val left = PriorityQueue(comp)
    val right = PriorityQueue(comp)
    val events = PriorityQueue<IntArray> { l, r ->
        val diff = l[0] - r[0]
        if (diff == 0) l[2] - r[2] else diff
    }
    left.addAll(0 until k)
    while (remain != 0 || events.isNotEmpty() || right.isNotEmpty()) {
        if (!crossing) {
            if (right.isNotEmpty()) {
                crossing = true
                val id = right.poll()
                events.offer(intArrayOf(current + time[id][2], id, LEFT_ARRIVED))
            } else if (left.isNotEmpty() && remain != 0) {
                remain--
                crossing = true
                val id = left.poll()
                events.offer(intArrayOf(current + time[id][0], id, RIGHT_ARRIVED))
            }
        }
        val (t, id, type) = events.poll()
        current = t
        if (type == BOX_FETCHED)
            right.add(id)
        else if (type == BOX_PUT)
            left.add(id)
        else if (type == RIGHT_ARRIVED) {
            crossing = false
            events.offer(intArrayOf(current + time[id][1], id, BOX_FETCHED))
        } else if (type == LEFT_ARRIVED) {
            crossing = false
            events.offer(intArrayOf(current + time[id][3], id, BOX_PUT))
            result = current
        }
    }
    return result
}