package cn_solution

fun asteroidsDestroyed_sort(mass: Int, asteroids: IntArray): Boolean {
    asteroids.sort()
    var sum = mass + 0L
    for (asteroid in asteroids) {
        if (sum < asteroid)
            return false
        sum += asteroid
    }
    return true
}

fun asteroidsDestroyed_groupByBitLength(mass: Int, asteroids: IntArray): Boolean {
    val min = IntArray(32) { Int.MAX_VALUE }
    val sum = LongArray(32)
    for (a in asteroids) {
        val w = 32 - a.countLeadingZeroBits()
        min[w] = minOf(min[w], a)
        sum[w] += a
    }
    var m = mass + 0L
    for (i in min.indices) {
        if (sum[i] != 0L && m < min[i])
            return false
        m += sum[i]
    }
    return true
}