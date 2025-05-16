package cn_solution

import kotlin.math.sqrt

fun minAreaFreeRect(points: Array<IntArray>): Double {
    fun dist(x: Int, y: Int, u: Int, v: Int) = 0L + (x - u) * (x - u) + (y - v) * (y - v)
    var ans = Double.MAX_VALUE
    val m = 80001
    val n = points.size
    val map = HashMap<Long, ArrayList<Int>>()
    for (i in 0 until n)
        for (j in i + 1 until n) {
            val (a, b) = points[i]
            val (c, d) = points[j]
            val x = a + c
            val y = b + d
            val len = dist(a, b, c, d)
            val key = (len * m + x) * m + y
            val list = map.computeIfAbsent(key) { ArrayList() }
            for (k in list) {
                val (e, f) = points[k]
                val s = dist(a, b, e, f)
                val t = dist(c, d, e, f)
                ans = minOf(ans, sqrt(s + 0.0) * sqrt(t + 0.0))
            }
            list.add(i)
        }
    return if (ans == Double.MAX_VALUE) 0.0 else ans
}