package cn_solution

fun taskSchedulerII(tasks: IntArray, space: Int): Long {
    val day = HashMap<Int, Long>()
    var cur = 0L
    for (t in tasks) {
        cur = maxOf(cur, day[t] ?: 0)
        day[t] = ++cur + space
    }
    return cur
}