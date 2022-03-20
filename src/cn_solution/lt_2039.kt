package cn_solution

fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
    val n = patience.size
    val adj = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        adj[u].add(v)
        adj[v].add(u)
    }
    val distance = IntArray(n)
    val q = ArrayDeque<Int>()
    var result = 0
    distance[0] = 0
    q.add(0)
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (v in adj[u]) {
            if (v == 0 || distance[v] != 0)
                continue
            val p = patience[v]
            val d = distance[u] + 2
            distance[v] = d
            q.add(v)
            result = maxOf(result, d + (d - 1) / p * p)
        }
    }
    return result + 1
}