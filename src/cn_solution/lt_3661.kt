package cn_solution

fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
    val n = robots.size
    val a = Array(n) { intArrayOf(robots[it], distance[it]) }
    a.sortBy { it[0] }
    walls.sort()
    fun ceiling(x: Int): Int {
        val pos = walls.binarySearch(x)
        return if (pos < 0) -pos - 1 else pos
    }

    val left = IntArray(2)
    val right = IntArray(2)
    for (i in 0 until n) {
        val (pos, dis) = a[i]
        var x = pos - dis
        if (i != 0)
            x = maxOf(x, a[i - 1][0] + 1)
        x = ceiling(x)
        var y = ceiling(pos + 1)
        val next = intArrayOf(y, left[1] + y - maxOf(x, left[0]))
        next[1] = maxOf(next[1], right[1] + y - maxOf(x, right[0]))
        x = ceiling(pos)
        y = pos + dis
        if (i != n - 1)
            y = minOf(y, a[i + 1][0] - 1)
        y = ceiling(y + 1)
        right[0] = y
        right[1] = maxOf(left[1], right[1]) + y - x
        next.copyInto(left)
    }
    return maxOf(left[1], right[1])
}