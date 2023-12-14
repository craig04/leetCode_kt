package cn_solution

fun minJumps(arr: IntArray): Int {
    val group = arr.indices.groupByTo(HashMap()) { arr[it] }
    val q = ArrayDeque<Int>()
    q.addLast(0)
    val step = IntArray(arr.size)
    step[0] = 1
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        if (cur == arr.lastIndex)
            return step[cur] - 1
        fun test(t: Int) {
            if (step[t] == 0) {
                step[t] = step[cur] + 1
                q.addLast(t)
            }
        }
        group.remove(arr[cur])?.forEach { test(it) }
        if (cur > 0)
            test(cur - 1)
        if (cur < arr.lastIndex)
            test(cur + 1)
    }
    return 0
}