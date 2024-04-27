package cn_solution

import java.util.*

fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
    val inf = Long.MAX_VALUE shr 2
    val adj = Array(n) { ArrayList<Int>() }
    for ((u, v, w) in edges) {
        adj[u].add(v)
        adj[u].add(w)
        adj[v].add(u)
        adj[v].add(w)
    }
    fun dijkstra(start: Int): LongArray {
        val dist = LongArray(n) { inf }
        val q = PriorityQueue<Pair<Long, Int>> { a, b -> a.first.compareTo(b.first) }
        dist[start] = 0
        q.add(Pair(0, start))
        while (q.isNotEmpty()) {
            val (d, u) = q.poll()
            if (d > dist[u])
                continue
            for (t in adj[u].indices step 2) {
                val v = adj[u][t]
                val temp = dist[u] + adj[u][t + 1]
                if (temp < dist[v]) {
                    dist[v] = temp
                    q.offer(Pair(temp, v))
                }
            }
        }
        return dist
    }

    val pos = dijkstra(0)
    val dist = pos[n - 1]
    if (dist == inf)
        return BooleanArray(edges.size)
    val neg = dijkstra(n - 1)
    return BooleanArray(edges.size) {
        val (u, v, w) = edges[it]
        pos[u] + neg[v] + w == dist || pos[v] + neg[u] + w == dist
    }
}