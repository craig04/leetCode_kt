package solution_cn

fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    return duration + (1 until timeSeries.size).sumBy {
        duration.coerceAtMost(timeSeries[it] - timeSeries[it - 1])
    }
}