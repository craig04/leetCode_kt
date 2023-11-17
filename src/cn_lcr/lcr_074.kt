package cn_lcr

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    var last = intervals[0].copyOf()
    val result = arrayListOf(last)
    for ((s, e) in intervals) {
        if (s <= last[1]) {
            last[1] = maxOf(last[1], e)
        } else {
            last = intArrayOf(s, e)
            result.add(last)
        }
    }
    return result.toTypedArray()
}