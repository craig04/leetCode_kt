package cn_solution

fun longestWPI(hours: IntArray): Int {
    val map = HashMap<Int, Int>()
    var days = 0
    var result = 0
    hours.forEachIndexed { i, h ->
        if (h > 8) days++ else days--
        result = maxOf(
            result, if (days > 0) i + 1 else i - (map[days - 1] ?: i)
        )
        map.putIfAbsent(days, i)
    }
    return result
}