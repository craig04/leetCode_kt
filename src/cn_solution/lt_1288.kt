package cn_solution

fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    intervals.sortWith(compareBy({ it[0] }, { -it[1] }))
    var ans = 0
    var end = 0
    for ((_, e) in intervals)
        if (end < e) {
            ans++
            end = e
        }
    return ans
}