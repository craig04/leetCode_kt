package solution

fun removeCoveredIntervals(intervals: Array<IntArray>): Int {

    intervals.sortWith(Comparator { lhs, rhs -> if (lhs[0] != rhs[0]) lhs[0] - rhs[0] else rhs[1] - lhs[1] })
    var index = 0
    var count = 1
    for (i in 1 until intervals.size) {
        if (intervals[i][1] > intervals[index][1]) {
            index = i
            count++
        }
    }
    return count
}