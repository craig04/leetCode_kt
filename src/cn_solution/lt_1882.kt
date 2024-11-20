package cn_solution

import java.util.*

fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
    val idle = PriorityQueue<Int>(compareBy({ servers[it] }, { it }))
    idle.addAll(servers.indices)
    val busy = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
    var time = 0
    val ans = IntArray(tasks.size)
    for (i in tasks.indices) {
        time = maxOf(time, i)
        if (idle.isEmpty())
            time = maxOf(time, busy.peek()[0])
        while ((busy.peek()?.get(0) ?: Int.MAX_VALUE) <= time)
            idle.add(busy.poll()[1])
        val idx = idle.poll()
        ans[i] = idx
        busy.add(intArrayOf(time + tasks[i], ans[i]))
    }
    return ans
}