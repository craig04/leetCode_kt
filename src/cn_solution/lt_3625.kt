package cn_solution

private fun countTrapezoids(points: Array<IntArray>): Int {
    fun Double.toKey() = if (this == -0.0) 0.0 else this
    val slope = HashMap<Double, ArrayList<Double>>()
    val center = HashMap<Int, ArrayList<Double>>()
    for (i in points.indices) {
        val (x1, y1) = points[i]
        for (j in i + 1 until points.size) {
            val (x2, y2) = points[j]
            var k = Double.POSITIVE_INFINITY
            var b = 0.0 + x1
            if (x1 != x2) {
                val dx = x2 - x1
                val dy = y2 - y1
                k = (dy * 1.0 / dx).toKey()
                b = ((y1 * dx - x1 * dy) * 1.0 / dx).toKey()
            }
            slope.computeIfAbsent(k) { ArrayList() }.add(b)
            val x = x1 + x2 + 2000
            val y = y1 + y2 + 2000
            val key = x.shl(16) + y
            center.computeIfAbsent(key) { ArrayList() }.add(k)
        }
    }
    fun <T> HashMap<T, ArrayList<Double>>.count() = entries.sumOf { (_, value) ->
        var res = 0
        var pre = 0
        for ((_, cur) in value.groupingBy { it }.eachCount()) {
            res += pre * cur
            pre += cur
        }
        res
    }
    return slope.count() - center.count()
}