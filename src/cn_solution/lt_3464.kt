package cn_solution

fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
    val n = points.size
    val s = side + 0L
    val p = side * 4L
    val a = LongArray(n * 2)
    points.forEachIndexed { i, (x, y) ->
        a[i] = when {
            y == 0 -> x + 0L
            x == 0 -> p - y
            x == side -> s + y
            else -> 3 * s - x
        }
        a[i + n] = a[i] + p
    }
    a.sort()
    var l = 1L
    var r = s
    while (l != r) {
        val mid = (l + r + 1) shr 1
        if ((0 until n).any { i ->
                var j = i
                var cnt = 1
                while (cnt < k && j < i + n) {
                    var x = j + 1
                    var y = i + n
                    while (x != y) {
                        val z = (x + y) shr 1
                        if (a[z] - a[j] < mid)
                            x = z + 1
                        else
                            y = z
                    }
                    if (x == i + n)
                        return@any false
                    cnt++
                    j = x
                }
                a[i] + p - a[j] >= mid
            })
            l = mid
        else
            r = mid - 1
    }
    return l.toInt()
}