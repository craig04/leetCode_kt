package cn_solution

import java.util.*

fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v, w) in times) {
        g[u - 1].add(v - 1)
        g[u - 1].add(w)
    }
    val dist = IntArray(n) { Int.MAX_VALUE }
    val q = PriorityQueue<IntArray> { a, b -> a[1] - b[1] }
    dist[k - 1] = 0
    q.add(intArrayOf(k - 1, 0))
    while (q.isNotEmpty()) {
        val (u, d) = q.poll()
        if (d > dist[u])
            continue
        for (i in g[u].indices step 2) {
            val v = g[u][i]
            val w = g[u][i + 1]
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w
                q.add(intArrayOf(v, dist[v]))
            }
        }
    }
    return if (Int.MAX_VALUE in dist) -1 else dist.max()
}