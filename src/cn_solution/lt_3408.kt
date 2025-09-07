package cn_solution

import java.util.*

class TaskManager(tasks: List<List<Int>>) {

    private val tasks = HashMap<Int, IntArray>()
    private val q = PriorityQueue<IntArray> { (_, t1, p1), (_, t2, p2) ->
        if (p1 == p2) t2 - t1 else p2 - p1
    }

    init {
        for ((userId, taskId, priority) in tasks)
            add(userId, taskId, priority)
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        val task = intArrayOf(userId, taskId, priority)
        tasks[taskId] = task
        q += task
    }

    fun edit(taskId: Int, newPriority: Int) {
        val userId = tasks[taskId]?.get(0) ?: return
        add(userId, taskId, newPriority)
    }

    fun rmv(taskId: Int) {
        tasks -= taskId
    }

    fun execTop(): Int {
        while (q.isNotEmpty()) {
            val expire = q.poll()
            val latest = tasks[expire[1]] ?: continue
            if (expire === latest) {
                tasks -= expire[1]
                return expire[0]
            }
        }
        return -1
    }
}