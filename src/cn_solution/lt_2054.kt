package cn_solution

fun maxTwoEvents(events: Array<IntArray>): Int {
    events.sortBy { it[1] }
    val stack = arrayListOf(intArrayOf(0, 0, 0))
    var ans = 0
    for (event in events) {
        val (s, _, v) = event
        var l = 0
        var r = stack.lastIndex
        while (l != r) {
            val m = (l + r + 1) / 2
            if (stack[m][1] < s)
                l = m
            else
                r = m - 1
        }
        ans = maxOf(ans, v + stack[l][2])
        if (v > stack.last()[2])
            stack.add(event)
    }
    return ans
}