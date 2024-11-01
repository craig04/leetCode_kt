package cn_solution

import kotlin.math.abs

fun canReachCorner(xCorner: Int, yCorner: Int, circles: Array<IntArray>): Boolean {

    fun inCircle(c: LongArray, x: Int, y: Int): Boolean {
        val dx = x - c[0]
        val dy = y - c[1]
        return dx * dx + dy * dy <= c[2] * c[2]
    }

    fun crossUpLeft(c: LongArray): Boolean {
        val (x, y, r) = c
        return x <= xCorner && abs(y - yCorner) <= r ||
                y <= yCorner && x <= r ||
                y >= yCorner && inCircle(c, 0, yCorner)
    }

    fun crossDownRight(c: LongArray): Boolean {
        val (x, y, r) = c
        return y <= yCorner && abs(x - xCorner) <= r ||
                x <= xCorner && y <= r ||
                x > xCorner && inCircle(c, xCorner, 0)
    }

    val n = circles.size
    val c = Array(n) { i ->
        circles[i].let {
            val ans = LongArray(3) { j -> it[j].toLong() }
            if (inCircle(ans, 0, 0) || inCircle(ans, xCorner, yCorner))
                return false
            ans
        }
    }
    val p = IntArray(n + 2) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int) {
        val u = find(x)
        val v = find(y)
        if (u != v)
            p[u] = v
    }

    return circles.indices.all { i ->
        val c1 = c[i]
        if (crossUpLeft(c1))
            union(i, n)
        if (crossDownRight(c1))
            union(i, n + 1)
        for (j in 0 until i) {
            val c2 = c[j]
            val dx = c1[0] - c2[0]
            val dy = c1[1] - c2[1]
            val sr = c1[2] + c2[2]
            if (dx * dx + dy * dy <= sr * sr &&
                c1[0] * c2[2] + c2[0] * c1[2] < (c1[2] + c2[2]) * xCorner &&
                c1[1] * c2[2] + c2[1] * c1[2] < (c1[2] + c2[2]) * yCorner
            )
                union(i, j)
        }
        find(n) != find(n + 1)
    }
}