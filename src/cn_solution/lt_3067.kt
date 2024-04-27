package cn_solution

fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
    val n = edges.size + 1
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v, w) ->
        adj[u].add(v)
        adj[u].add(w)
        adj[v].add(u)
        adj[v].add(w)
    }
    fun dfs(u: Int, p: Int, dist: Int): Int {
        var res = 0
        if (dist % signalSpeed == 0)
            res++
        for (j in adj[u].indices step 2) {
            val v = adj[u][j]
            if (v == p)
                continue
            val w = adj[u][j + 1]
            res += dfs(v, u, dist + w)
        }
        return res
    }
    return IntArray(n) { x ->
        var res = 0
        var sum = 0
        for (i in adj[x].indices step 2) {
            val cnt = dfs(adj[x][i], x, adj[x][i + 1])
            res += sum * cnt
            sum += cnt
        }
        res
    }
}