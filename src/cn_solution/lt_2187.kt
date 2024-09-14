package cn_solution

fun minimumTime(time: IntArray, totalTrips: Int): Long {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (t in time) {
        min = minOf(t, min)
        max = maxOf(t, max)
    }
    val n = time.size
    var l = (totalTrips + n - 1L) / n * min
    var r = (totalTrips + n - 1L) / n * max
    while (l != r) {
        val mid = (l + r) / 2
        var trips = 0L
        for (t in time) {
            trips += mid / t
            if (trips >= totalTrips)
                break
        }
        if (trips >= totalTrips)
            r = mid
        else
            l = mid + 1
    }
    return l
}