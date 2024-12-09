package cn_solution

fun buttonWithLongestTime(events: Array<IntArray>): Int {
    var (idx, time) = events[0]
    for (k in 1 until events.size) {
        var (i, t) = events[k]
        t -= events[k - 1][1]
        if (t > time || t == time && i < idx) {
            idx = i
            time = t
        }
    }
    return idx
}