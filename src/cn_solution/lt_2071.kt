package cn_solution

fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
    var l = 0
    var r = minOf(tasks.size, workers.size)
    tasks.sort()
    workers.sortDescending()
    while (l != r) {
        val m = (l + r + 1) shr 1
        fun check(): Boolean {
            var p = pills
            val q = ArrayDeque<Int>()
            var j = 0
            for (i in m - 1 downTo 0) {
                val t = tasks[i]
                while (j != m && workers[j] + strength >= t)
                    q.addLast(workers[j++])
                when {
                    q.isEmpty() -> return false
                    q.first() >= t -> q.removeFirst()
                    p-- > 0 -> q.removeLast()
                    else -> return false
                }
            }
            return true
        }
        if (check())
            l = m
        else
            r = m - 1
    }
    return l
}