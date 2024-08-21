package cn_solution

fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    return startTime.indices.count { queryTime in startTime[it]..endTime[it] }
}