package cn_solution

/**
 * 一种将无向图有向化的方法，保证每个节点的出度都不会超过 sqrt(2 * m)，其中 m 为边数
 */
fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
    val d = IntArray(n)
    val adj = Array(n) { HashSet<Int>() }
    edges.forEach {
        val u = --it[0]
        val v = --it[1]
        d[u]++
        d[v]++
        adj[u].add(v)
        adj[v].add(u)
    }
    val h = Array(n) { ArrayList<Int>(n) }
    edges.forEach { (u, v) ->
        if (d[u] < d[v] || (d[u] == d[v] && u <= v))
            h[u].add(v)
        else
            h[v].add(u)
    }
    var result = Int.MAX_VALUE
    for (u in 0 until n)
        for (v in h[u])
            for (w in h[u])
                if (v in adj[w])
                    result = minOf(result, d[u] + d[v] + d[w])
    return if (result == Int.MAX_VALUE) -1 else result - 6
}