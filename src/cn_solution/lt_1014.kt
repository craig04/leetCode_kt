package cn_solution

fun maxScoreSightseeingPair(values: IntArray): Int {
    var first = 0
    var total = 0
    for (i in values.indices) {
        total = maxOf(total, values[i] - i + first)
        first = maxOf(first, values[i] + i)
    }
    return total
}