package cn_solution

import java.util.*

fun minTime(n: Int, edges: Array<IntArray>): Int {
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges)
        g[edge[0]].add(edge)
    val t = IntArray(n) { Int.MAX_VALUE }
    val q = PriorityQueue<IntArray> { a, b -> a[1] - b[1] }
    t[0] = 0
    q.add(intArrayOf(0, 0))
    while (q.isNotEmpty()) {
        val (u, x) = q.poll()
        if (x > t[u])
            continue
        if (u == n - 1)
            return x
        for ((_, v, start, end) in g[u]) {
            if (x > end)
                continue
            val y = maxOf(x, start) + 1
            if (t[v] > y) {
                t[v] = y
                q.offer(intArrayOf(v, y))
            }
        }
    }
    return -1
}