package cn_solution

fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {
    val n = values.size
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v, t) in edges) {
        g[u].add(v)
        g[u].add(t)
        g[v].add(u)
        g[v].add(t)
    }
    var ans = 0
    var time = 0
    var value = 0
    val visit = BooleanArray(n + 1)
    fun dfs(u: Int) {
        val visited = visit[u]
        if (!visited)
            value += values[u]
        visit[u] = true
        if (u == 0)
            ans = maxOf(ans, value)
        for (i in g[u].indices step 2) {
            time += g[u][i + 1]
            if (time <= maxTime)
                dfs(g[u][i])
            time -= g[u][i + 1]
        }
        visit[u] = visited
        if (!visited)
            value -= values[u]
    }
    dfs(0)
    return ans
}