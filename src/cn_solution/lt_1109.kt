package cn_solution

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val cnt = IntArray(n)
    for ((f, l, s) in bookings) {
        cnt[f - 1] += s
        if (l != n)
            cnt[l] -= s
    }
    for (i in 1 until n)
        cnt[i] += cnt[i - 1]
    return cnt
}