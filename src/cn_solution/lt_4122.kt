package cn_solution

fun earliestActivationTimes(n: Int, edges: Array<IntArray>, requiredSignals: IntArray): LongArray {
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges)
        g[edge[0]] += edge
    val q = java.util.PriorityQueue<Pair<Long, Int>> { (a), (b) -> a.compareTo(b) }
    q += Pair(0, 0)
    requiredSignals[0] = 1
    val ans = LongArray(n) { -1 }
    while (q.isNotEmpty()) {
        val (t, u) = q.poll()
        if (--requiredSignals[u] == 0) {
            ans[u] = t
            for ((_, v, delay) in g[u])
                q += Pair(t + delay, v)
        }
    }
    return ans
}