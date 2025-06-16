package cn_solution

fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
    val r = Array(n) { IntArray(n) }
    for (i in 0 until n)
        for (t in preferences[i].indices)
            r[i][preferences[i][t]] = t
    val p = IntArray(n)
    for ((x, y) in pairs) {
        p[x] = y
        p[y] = x
    }
    return (0 until n).count { x ->
        val y = p[x]
        for (u in 0 until n) {
            if (u == x || u == y || r[x][u] >= r[x][y])
                continue
            val v = p[u]
            if (r[u][x] < r[u][v])
                return@count true
        }
        false
    }
}