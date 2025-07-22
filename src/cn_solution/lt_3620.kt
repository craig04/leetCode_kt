package cn_solution

fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
    val n = online.size
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges) {
        val (u, v, c) = edge
        if (online[u] && online[v] && c <= k)
            g[u].add(edge)
    }
    var l = -1
    var r = 1000000000
    val cost = LongArray(n)
    while (l != r) {
        val m = (l + r + 1) / 2
        cost.fill(-1)
        cost[n - 1] = 0
        fun dfs(u: Int): Long {
            if (cost[u] == -1L) {
                var res = Long.MAX_VALUE / 2
                for ((_, v, c) in g[u]) {
                    if (online[v] && c >= m)
                        res = minOf(res, c + dfs(v))
                }
                cost[u] = res
            }
            return cost[u]
        }
        if (dfs(0) <= k)
            l = m
        else
            r = m - 1
    }
    return l
}