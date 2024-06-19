package cn_lcp

fun temperatureTrend(temperatureA: IntArray, temperatureB: IntArray): Int {
    var days = 0
    return (1 until temperatureA.size).maxOf {
        val a = temperatureA[it].compareTo(temperatureA[it - 1])
        val b = temperatureB[it].compareTo(temperatureB[it - 1])
        days = if (a == b) days + 1 else 0
        days
    }
}