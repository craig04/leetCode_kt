package cn_solution

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[0] }
    var count = 0
    var right = Int.MIN_VALUE
    for (itv in intervals) {
        if (right <= itv[0]) {
            right = itv[1]
        } else {
            right = minOf(right, itv[1])
            count++
        }
    }
    return count
}
