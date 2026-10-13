package cn_solution

fun minSelection(availableIntervals: Array<IntArray>, targetIntervals: Array<IntArray>): Int {
    availableIntervals.sortBy { it[0] }
    targetIntervals.sortBy { it[0] }
    var i = 0
    var cur = 0
    var ans = 0
    for ((s, e) in targetIntervals) {
        while (cur < e) {
            val uncover = maxOf(cur, s)
            var next = cur
            while (i != availableIntervals.size && availableIntervals[i][0] <= uncover)
                next = maxOf(next, availableIntervals[i++][1])
            if (next < uncover || next == cur)
                return -1
            cur = next
            ans++
        }
    }
    return ans
}