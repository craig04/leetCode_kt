package cn_solution

import java.util.*

fun getOrder(tasks: Array<IntArray>): IntArray {
    val n = tasks.size
    val sorted = Array(n) { it }
    sorted.sortBy { tasks[it][0].toLong().shl(32).or(tasks[it][1].toLong()) }
    val q = PriorityQueue(Comparator<Int> { l, r ->
        val diff = tasks[l][1] - tasks[r][1]
        if (diff == 0) l - r else diff
    })
    var i = 0
    var time = 0
    var index = 0
    val result = IntArray(n)
    while (q.isNotEmpty() || i != n) {
        if (q.isEmpty()) {
            q.add(sorted[i++])
        }
        val t = q.poll()
        result[index++] = t
        time = maxOf(time, tasks[t][0]) + tasks[t][1]
        while (i != n && tasks[sorted[i]][0] <= time) {
            q.add(sorted[i++])
        }
    }
    return result
}