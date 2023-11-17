package cn_solution

import kotlin.math.absoluteValue

fun minimumEffortPath_binarySearch(heights: Array<IntArray>): Int {
    val n = heights.size
    val m = heights[0].size
    val len = n * m
    if (len == 1)
        return 0
    val q = IntArray(len)
    var h: Int
    var t: Int
    val visit = BooleanArray(len)
    fun test(threshold: Int): Boolean {
        visit.fill(false)
        visit[0] = true
        h = 0
        t = 0
        q[t++] = 0
        while (h < t) {
            val idx = q[h++]
            if (idx == len - 1)
                return true
            val x = idx / m
            val y = idx % m
            val height = heights[x][y]
            fun move(u: Int, v: Int) {
                if (u !in 0 until n || v !in 0 until m)
                    return
                val pos = u * m + v
                if (!visit[pos] && (height - heights[u][v]).absoluteValue <= threshold) {
                    visit[pos] = true
                    q[t++] = pos
                }
            }
            move(x, y - 1)
            move(x, y + 1)
            move(x - 1, y)
            move(x + 1, y)
        }
        return false
    }

    var l = 1
    var r = 1000000
    while (l != r) {
        val mid = (l + r) shr 1
        if (test(mid))
            r = mid
        else
            l = mid + 1
    }
    return r
}

fun minimumEffortPath_unionFind(heights: Array<IntArray>): Int {
    val n = heights.size
    val m = heights[0].size
    val len = n * m
    if (len == 1)
        return 0
    var pos = 0
    val e = Array(2 * len - n - m) { IntArray(3) }
    fun add(u: Int, v: Int, d: Int) {
        e[pos][0] = d
        e[pos][1] = u
        e[pos][2] = v
        pos++
    }
    for (i in 0 until n)
        for (j in 0 until m) {
            val idx = i * m + j
            val h = heights[i][j]
            if (i != n - 1)
                add(idx, idx + m, (h - heights[i + 1][j]).absoluteValue)
            if (j != m - 1)
                add(idx, idx + 1, (h - heights[i][j + 1]).absoluteValue)
        }
    e.sortBy { it[0] }
    val p = IntArray(len) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (edge in e) {
        val d = edge[0]
        val x = find(edge[1])
        val y = find(edge[2])
        if (x != y) {
            p[x] = y
            if (find(0) == find(len - 1))
                return d
        }
    }
    return -1
}