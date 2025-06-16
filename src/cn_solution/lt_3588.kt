package cn_solution

fun maxArea(coords: Array<IntArray>): Long {
    fun maxArea(): Long {
        val map = HashMap<Int, IntArray>()
        var left = 1000000
        var right = 1
        for ((x, y) in coords) {
            val a = map.computeIfAbsent(x) { intArrayOf(1000000, 1) }
            a[0] = minOf(a[0], y)
            a[1] = maxOf(a[1], y)
            left = minOf(left, x)
            right = maxOf(right, x)
        }
        return map.maxOf { (x, y) ->
            val (bottom, top) = y
            (top - bottom) * 1L * maxOf(right - x, x - left)
        }
    }

    var ans = maxArea()
    for (a in coords) {
        val temp = a[0]
        a[0] = a[1]
        a[1] = temp
    }
    ans = maxOf(ans, maxArea())
    return if (ans == 0L) -1L else ans
}