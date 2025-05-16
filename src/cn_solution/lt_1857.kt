package cn_solution

fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val n = colors.length
    val g = Array(n) { ArrayList<Int>() }
    val d = IntArray(n)
    for ((u, v) in edges) {
        g[u].add(v)
        d[v]++
    }
    val q = d.indices.filterTo(ArrayDeque()) { d[it] == 0 }
    var t = q.size
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (v in g[u])
            if (--d[v] == 0) {
                q.add(v)
                t++
            }
    }
    if (t != n)
        return -1
    val vis = BooleanArray(n)
    val cnt = Array(n) { IntArray(26) }
    fun dfs(u: Int) {
        if (vis[u])
            return
        vis[u] = true
        for (v in g[u]) {
            dfs(v)
            for (i in 0 until 26)
                cnt[u][i] = maxOf(cnt[u][i], cnt[v][i])
        }
        cnt[u][colors[u] - 'a']++
    }
    (0 until n).forEach(::dfs)
    return cnt.maxOf { it.max() }
}