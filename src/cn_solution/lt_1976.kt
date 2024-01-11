package cn_solution

import java.util.*

private fun countPaths(n: Int, roads: Array<IntArray>): Int {
    val adj = Array(n) { ArrayList<Int>() }
    for ((u, v, time) in roads) {
        adj[u].add(v)
        adj[u].add(time)
        adj[v].add(u)
        adj[v].add(time)
    }
    val q = PriorityQueue<Pair<Long, Int>> { l, r -> l.first.compareTo(r.first) }
    val dist = LongArray(n) { Long.MAX_VALUE }
    val ways = IntArray(n) { 0 }
    q.offer(Pair(0L, 0))
    dist[0] = 0
    ways[0] = 1
    while (q.isNotEmpty()) {
        val (d, u) = q.poll()
        if (d > dist[u])
            continue
        for (i in adj[u].indices step 2) {
            val v = adj[u][i]
            val time = adj[u][i + 1]
            val temp = dist[u] + time
            if (temp < dist[v]) {
                dist[v] = dist[u] + time
                ways[v] = ways[u]
                q.offer(Pair(dist[v], v))
            } else if (temp == dist[v]) {
                ways[v] = (ways[v] + ways[u]) % 1000000007
            }
        }
    }
    return ways[n - 1]
}