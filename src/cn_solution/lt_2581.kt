package cn_solution

fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
    val n = edges.size + 1
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    fun hash(u: Int, v: Int) = u.toLong().shl(32) + v
    val set = guesses.mapTo(HashSet()) { hash(it[0], it[1]) }
    var init = 0
    fun dfs1(u: Int, fa: Int) {
        if (hash(fa, u) in set)
            init++
        for (v in adj[u])
            if (v != fa)
                dfs1(v, u)
    }
    dfs1(0, -1)
    var result = 0
    fun dfs2(u: Int, f: Int, count: Int) {
        if (count >= k)
            result++
        for (v in adj[u])
            if (v != f) {
                var delta = 0
                if (hash(u, v) in set)
                    delta--
                if (hash(v, u) in set)
                    delta++
                dfs2(v, u, count + delta)
            }
    }
    dfs2(0, -1, init)
    return result
}