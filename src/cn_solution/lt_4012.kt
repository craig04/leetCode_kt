package cn_solution

fun countTasks(tasks: IntArray, shifts: IntArray): IntArray {
    val n = tasks.size
    val pre = LongArray(n + 1)
    for (i in tasks.indices)
        pre[i + 1] = pre[i] + tasks[i]
    var t = 0L
    return IntArray(shifts.size) {
        t += shifts[it]
        if (t >= pre[n]) {
            t = 0L
            0
        } else {
            var i = pre.binarySearch(t + 1)
            if (i < 0)
                i = i.inv()
            n - i + 1
        }
    }
}