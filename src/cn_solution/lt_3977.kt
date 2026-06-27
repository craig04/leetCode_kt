package cn_solution

fun minTimeMaxPower(
    n: Int,
    edges: Array<IntArray>,
    power: Int,
    cost: IntArray,
    source: Int,
    target: Int
): LongArray {
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges)
        if (edge[0] != edge[1])
            g[edge[0]].add(edge)
    val dp = Array(n) { LongArray(power + 1) { Long.MAX_VALUE } }
    dp[source][power] = 0
    val pq = java.util.PriorityQueue<Triple<Int, Int, Long>> { (_, p, t), (_, q, s) ->
        if (t == s) q - p else t.compareTo(s)
    }
    pq.offer(Triple(source, power, 0L))
    while (pq.isNotEmpty()) {
        val (u, p, t) = pq.poll()
        if (u == target)
            return longArrayOf(t, p + 0L)
        if (t != dp[u][p] || p < cost[u])
            continue
        for ((_, v, w) in g[u]) {
            val q = p - cost[u]
            val s = t + w
            if (s < dp[v][q]) {
                dp[v][q] = s
                pq.offer(Triple(v, q, s))
            }
        }
    }
    return longArrayOf(-1, -1)
}