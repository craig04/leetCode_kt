package cn_solution

fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val set = restricted.toSet()
    var result = 0
    fun dfs(u: Int, p: Int) {
        if (u in set)
            return
        result++
        for (v in adj[u])
            if (v != p)
                dfs(v, u)
    }
    dfs(0, -1)
    return result
}