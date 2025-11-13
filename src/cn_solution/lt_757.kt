package cn_solution

fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }
    var x = -1
    var y = -1
    var ans = 0
    for ((l, r) in intervals) {
        if (y < l) {
            x = r - 1
            y = r
            ans += 2
        } else if (x < l) {
            x = minOf(y, r - 1)
            y = r
            ans += 1
        }
    }
    return ans
}