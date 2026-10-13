package cn_solution

private fun minCost(n: Int, colors: String, edges: Array<IntArray>): Long {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u] += v
        g[v] += u
    }
    val red = LongArray(n)
    val blue = LongArray(n)
    val size = LongArray(n)
    fun dfs(u: Int, p: Int) {
        size[u] = 1
        for (v in g[u])
            if (v != p) {
                dfs(v, u)
                red[u] += minOf(red[v], blue[v])
                blue[u] += blue[v]
                size[u] += size[v]
            }
        if (colors[u] == 'R')
            blue[u] += size[u]
        else
            red[u] += size[u]
    }
    dfs(0, -1)
    return (0 until n).fold(blue[0]) { ans, i ->
        minOf(ans, blue[0] - blue[i] + red[i])
    }
}