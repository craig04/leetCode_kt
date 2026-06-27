package cn_solution

fun minScore(n: Int, roads: Array<IntArray>): Int {
    val g = Array(n + 1) { ArrayList<IntArray>() }
    for ((u, v, w) in roads) {
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, w))
    }
    val vis = BooleanArray(n + 1)
    var ans = Int.MAX_VALUE
    fun dfs(u: Int) {
        vis[u] = true
        for ((v, w) in g[u]) {
            ans = minOf(ans, w)
            if (!vis[v])
                dfs(v)
        }
    }
    dfs(1)
    return ans
}