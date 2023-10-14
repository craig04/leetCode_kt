package cn_lcr

fun isBipartite(graph: Array<IntArray>): Boolean {
    val f = IntArray(graph.size)
    fun dfs(u: Int, group: Int): Boolean {
        if (f[u] != 0)
            return f[u] == group
        f[u] = group
        return graph[u].all { dfs(it, group xor 3) }
    }
    return graph.indices.all { f[it] != 0 || dfs(it, 1) }
}