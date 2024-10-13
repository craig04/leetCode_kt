package cn_solution

private fun countCompleteDayPairs(hours: IntArray): Long {
    val map = IntArray(24)
    var ans = 0L
    for (hour in hours) {
        val mod = hour % 24
        ans += map[(24 - mod) % 24]
        map[mod]++
    }
    return ans
}