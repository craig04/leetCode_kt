package cn_solution

fun countDays(days: Int, meetings: Array<IntArray>): Int {
    meetings.sortBy { it[0] }
    var end = 0
    var ans = 0
    for ((s, e) in meetings) {
        ans += maxOf(s - end - 1, 0)
        end = maxOf(end, e)
    }
    return ans + days - end
}