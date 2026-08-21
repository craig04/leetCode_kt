package cn_solution

fun minAreaRect(points: Array<IntArray>): Int {
    val set = points.mapTo(HashSet()) { (x, y) -> x * 40001 + y }
    var ans = Int.MAX_VALUE
    for (i in points.indices) {
        val (a, b) = points[i]
        for (j in points.indices) {
            val (c, d) = points[j]
            if (i == j || a >= c || b >= d)
                continue
            val x = a * 40001 + d
            val y = c * 40001 + b
            if (x in set && y in set)
                ans = minOf(ans, (c - a) * (d - b))
        }
    }
    return if (ans == Int.MAX_VALUE) 0 else ans
}