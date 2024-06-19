package cn_solution

fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
    val land = Array(row) { BooleanArray(col) }
    val n = row * col
    val p = IntArray(n + 2) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val u = find(x)
        val v = find(y)
        if (u != v)
            p[maxOf(u, v)] = minOf(u, v)
        return u != v
    }

    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val rows = 0 until row
    val cols = 0 until col
    for (i in cells.indices.reversed()) {
        val r = cells[i][0] - 1
        val c = cells[i][1] - 1
        land[r][c] = true
        if (r == 0)
            union(c, n)
        if (r == row - 1)
            union(r * col + c, n + 1)
        for (j in d.indices step 2) {
            val x = r + d[j]
            val y = c + d[j + 1]
            if (x in rows && y in cols && land[x][y])
                union(r * col + c, x * col + y)
        }
        if (find(n + 1) == find(n))
            return i
    }
    return 0
}