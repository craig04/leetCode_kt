package cn_solution

import java.util.*

fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val starts = intervals.indices.associateByTo(TreeMap()) { intervals[it][0] }
    return IntArray(intervals.size) { starts.ceilingEntry(intervals[it][1])?.value ?: -1 }
}