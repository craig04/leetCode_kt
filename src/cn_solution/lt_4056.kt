package cn_solution

private fun countIntersectingIntervals(intervals: Array<IntArray>): Int {
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
    return n * (n - 1) / 2 - s.indices.sumOf { j ->
        while (i != n && e[i] < s[j])
            i++
        i
    }
}