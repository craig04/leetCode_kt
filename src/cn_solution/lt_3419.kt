package cn_solution

fun minMaxWeight(n: Int, edges: Array<IntArray>, threshold: Int): Int {
    var len = 0
    val g = Array(n) { ArrayList<IntArray>() }
    for (e in edges) {
        g[e[1]].add(e)
        len = maxOf(len, e[2])
    }
    var l = 1
    var r = len + 1
    val vis = IntArray(n)
    while (l < r) {
        val m = (l + r) / 2
        fun dfs(u: Int) {
            if (vis[u] == m)
                return
            vis[u] = m
            for ((v, _, w) in g[u])
                if (w <= m)
                    dfs(v)
        }
        dfs(0)
        if (vis.any { it != m })
            l = m + 1
        else
            r = m
    }
    return if (r <= len) r else -1
}