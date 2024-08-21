package cn_solution

fun shortestPathLength(graph: Array<IntArray>): Int {
    val n = graph.size
    val dist = Array(n) { IntArray(1 shl n) { -1 } }
    val q = ArrayDeque<IntArray>()
    for (i in 0 until n) {
        q.add(intArrayOf(i, 1 shl i, 0))
        dist[i][1 shl i] = 0
    }
    var ans = Int.MAX_VALUE
    val mask = 1.shl(n) - 1
    while (q.isNotEmpty()) {
        val (u, curr, d) = q.removeFirst()
        if (curr == mask)
            ans = minOf(ans, d)
        for (v in graph[u]) {
            val next = 1 shl v or curr
            if (dist[v][next] == -1) {
                dist[v][next] = d + 1
                q.add(intArrayOf(v, next, d + 1))
            }
        }
    }
    return ans
}