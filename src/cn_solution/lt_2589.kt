package cn_solution

fun findMinimumTime(tasks: Array<IntArray>): Int {
    var time = 0
    val latest = tasks.maxOf { it[1] }
    for (i in 0..latest) {
        if (tasks.any { it[2] != 0 && it[1] - it[2] + 1 == i }) {
            time++
            for (t in tasks)
                if (t[2] != 0 && i in t[0]..t[1])
                    t[2]--
        }
    }
    return time
}