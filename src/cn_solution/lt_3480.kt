package cn_solution

fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
    val g = Array(n + 1) { ArrayList<Int>() }
    for ((a, b) in conflictingPairs)
        g[minOf(a, b)].add(maxOf(a, b))
    var origin = 0L
    var remove = 0L
    var extra = 0L
    var x = n + 1
    var y = n + 1
    for (i in n downTo 1) {
        val pre = x
        for (b in g[i]) {
            if (b < x) {
                y = x
                x = b
            } else if (b < y) {
                y = b
            }
        }
        origin += x - i
        if (pre != x)
            extra = 0
        extra += y - x
        remove = maxOf(remove, extra)
    }
    return origin + remove
}