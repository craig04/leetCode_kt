package cn_solution

fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    return duration + (1 until timeSeries.size).sumOf {
        duration.coerceAtMost(timeSeries[it] - timeSeries[it - 1])
    }
}