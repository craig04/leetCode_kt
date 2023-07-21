package cn_solution

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val list = ArrayList<IntArray>()
    var i = 0
    val n = intervals.size
    var left = newInterval[0]
    var right = newInterval[1]
    while (i != n && intervals[i][1] < left)
        list.add(intervals[i++])
    if (i != n)
        left = minOf(left, intervals[i][0])
    while (i != n && intervals[i][0] <= right)
        right = maxOf(right, intervals[i++][1])
    list.add(intArrayOf(left, right))
    while (i != n)
        list.add(intervals[i++])
    return list.toTypedArray()
}