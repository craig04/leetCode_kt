package cn_solution

fun maxDifference(s: String): Int {
    val cnt = s.groupingBy { it }.eachCount()
    var x = Int.MAX_VALUE
    var y = 0
    for ((_, c) in cnt) {
        if (c % 2 == 0)
            x = minOf(x, c)
        else
            y = maxOf(y, c)
    }
    return y - x
}