package cn_solution

fun maxRunTime(n: Int, batteries: IntArray): Long {
    val t = LongArray(batteries.size) { batteries[it].toLong() }
    var l = 1L
    var r = t.sum() / n
    while (l != r) {
        val mid = (l + r + 1) shr 1
        val total = mid * n
        if (t.sumOf { minOf(mid, it) } >= total)
            l = mid
        else
            r = mid - 1
    }
    return l
}