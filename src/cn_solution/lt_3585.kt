package cn_solution

fun findMedian(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val g = Array(n) { ArrayList<IntArray>() }
    for ((u, v, w) in edges) {
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, w))
    }
    val m = 33 - (n - 2).countLeadingZeroBits()
    val dist = LongArray(n)
    val depth = IntArray(n)
    val father = Array(n) { IntArray(m) { -1 } }
    fun dfs(u: Int, fa: Int) {
        for ((v, w) in g[u])
            if (v != fa) {
                dist[v] = dist[u] + w
                depth[v] = depth[u] + 1
                father[v][0] = u
                dfs(v, u)
            }
    }
    dfs(0, -1)
    for (j in 1 until m)
        for (i in 0 until n) {
            val fa = father[i][j - 1]
            if (fa != -1)
                father[i][j] = father[fa][j - 1]
        }
    return IntArray(queries.size) {
        fun advance(x: Int, diff: Int): Int {
            var y = x
            var d = diff
            while (d != 0) {
                y = father[y][d.countTrailingZeroBits()]
                d = d and (d - 1)
            }
            return y
        }
        val (u, v) = queries[it]
        if (u == v)
            return@IntArray u
        val diff = depth[u] - depth[v]
        var x = u
        var y = v
        if (diff < 0)
            y = advance(y, -diff)
        else
            x = advance(x, diff)
        val fa = if (x == y) x else {
            for (i in m - 1 downTo 0) {
                if (father[x][i] != father[y][i]) {
                    x = father[x][i]
                    y = father[y][i]
                }
            }
            father[x][0]
        }
        val left = dist[u] - dist[fa]
        val right = dist[v] - dist[fa]
        val total = left + right
        if (left * 2 >= total) {
            x = u
            for (i in m - 1 downTo 0) {
                val t = father[x][i]
                if (t != -1 && (dist[u] - dist[t]) * 2 < total)
                    x = t
            }
            father[x][0]
        } else {
            y = v
            for (i in m - 1 downTo 0) {
                val t = father[y][i]
                if (t != -1 && (dist[v] - dist[t]) * 2 <= total)
                    y = t
            }
            y
        }
    }
}