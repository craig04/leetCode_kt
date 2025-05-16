package cn_solution

fun minimumWeight(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<IntArray>() }
    edges.forEach { (u, v, w) ->
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, w))
    }
    val m = 33 - (n - 2).countLeadingZeroBits()
    val dist = IntArray(n)
    val depth = IntArray(n)
    val father = Array(n) { IntArray(m) { -1 } }
    fun dfs(u: Int, fa: Int) {
        father[u][0] = fa
        for ((v, w) in g[u])
            if (v != fa) {
                dist[v] = dist[u] + w
                depth[v] = depth[u] + 1
                dfs(v, u)
            }
    }
    dfs(0, -1)
    for (j in 1 until m)
        for (i in 0 until n) {
            val k = father[i][j - 1]
            if (k != -1)
                father[i][j] = father[k][j - 1]
        }
    fun lca(u: Int, v: Int): Int {
        var x = u
        var y = v
        if (depth[x] < depth[y]) {
            val z = x
            x = y
            y = z
        }
        var diff = depth[x] - depth[y]
        while (diff != 0) {
            x = father[x][diff.countTrailingZeroBits()]
            diff = diff and (diff - 1)
        }
        if (x == y)
            return x
        for (i in m - 1 downTo 0) {
            if (father[x][i] != father[y][i]) {
                x = father[x][i]
                y = father[y][i]
            }
        }
        return father[x][0]
    }

    return IntArray(queries.size) {
        val (u, v, w) = queries[it]
        val x = lca(u, v)
        val y = lca(v, w)
        val z = lca(w, u)
        dist[u] + dist[v] + dist[w] - dist[x] - dist[y] - dist[z]
    }
}