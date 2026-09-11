package cn_solution

private fun countIntersectingIntervals(intervals: Array<IntArray>): Long {
    val n = intervals.size
    val s = ArrayList<Int>()
    val e = ArrayList<Int>()
    for ((x, y) in intervals) {
        s += x
        e += y
    }
    s.sort()
    e.sort()
    var i = 0
    return s.indices.fold(n * (n - 1L) / 2) { ans, j ->
        while (i != n && e[i] < s[j])
            i++
        ans - i
    }
}