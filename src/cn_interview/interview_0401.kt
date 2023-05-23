package cn_interview

fun findWhetherExistsPath(n: Int, graph: Array<IntArray>, start: Int, target: Int): Boolean {
    val visit = BooleanArray(n)
    val adj = Array(n) { HashSet<Int>() }
    graph.forEach { (u, v) ->
        if (u != v)
            adj[u].add(v)
    }
    fun dfs(u: Int): Boolean {
        if (u == target)
            return true
        if (visit[u])
            return false
        visit[u] = true
        return adj[u].any { dfs(it) }
    }
    return dfs(start)
}