package cn_solution

fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
    val n = startTime.size
    val e = Array(n + 2) { IntArray(2) }
    e[n + 1][0] = eventTime
    for (i in startTime.indices) {
        e[i + 1][0] = startTime[i]
        e[i + 1][1] = endTime[i]
    }
    e.sortBy { it[0] }
    var ans = 0
    var len = 0
    for (i in 1..n) {
        len += e[i][1] - e[i][0]
        if (i >= k) {
            val j = i - k + 1
            ans = maxOf(ans, e[i + 1][0] - e[j - 1][1] - len)
            len -= e[j][1] - e[j][0]
        }
    }
    return ans
}