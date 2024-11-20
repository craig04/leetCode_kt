package cn_lcp

fun processTasks(tasks: Array<IntArray>): Int {
    tasks.sortBy { it[1] }
    val st = arrayListOf(intArrayOf(-2, -2, 0))
    for (i in tasks.indices) {
        var (start, end, period) = tasks[i]
        var l = 0
        var r = st.lastIndex
        while (l != r) {
            val m = (l + r + 1) shr 1
            if (st[m][0] <= start)
                l = m
            else
                r = m - 1
        }
        period -= st.last()[2] - st[l][2] + maxOf(0, st[l][1] - start + 1)
        if (period <= 0)
            continue
        while (period >= end - st.last()[1]) {
            val (s, e) = st.removeLast()
            period += e - s + 1
        }
        st.add(intArrayOf(end - period + 1, end, st.last()[2] + period))
    }
    return st.last()[2]
}