package cn_solution

fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
    buses.sort()
    passengers.sort()
    var i = 0
    var c = 0
    for (t in buses) {
        c = capacity
        while (c != 0 && i != passengers.size && passengers[i] <= t) {
            c--
            i++
        }
    }
    --i
    var ans = if (c > 0) buses.last() else passengers[i]
    while (i >= 0 && ans == passengers[i--])
        ans--
    return ans
}