package cn_solution

import java.util.*

fun scheduleCourse(courses: Array<IntArray>): Int {
    courses.sortBy { it[1] }
    var cost = 0
    val q = PriorityQueue<Int> { l, r -> r - l }
    for ((duration, last) in courses) {
        if (cost + duration <= last) {
            cost += duration
            q.add(duration)
        } else if (q.isNotEmpty() && q.peek() > duration) {
            cost += duration - q.poll()
            q.add(duration)
        }
    }
    return q.size
}