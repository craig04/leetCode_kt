package cn_solution

fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges)
        g[edge[0]].add(edge)
    val dis = Array(n) { IntArray(k + 1) { Int.MAX_VALUE } }
    dis[0][1] = 0
    val q = java.util.PriorityQueue<IntArray> { (a), (b) -> a - b }
    q += intArrayOf(0, 0, 1)
    while (q.isNotEmpty()) {
        val (curr, u, x) = q.poll()
        if (curr != dis[u][x])
            continue
        for ((_, v, w) in g[u]) {
            val next = curr + w
            val y = if (labels[u] == labels[v]) x + 1 else 1
            if (y <= k && next < dis[v][y]) {
                dis[v][y] = next
                q += intArrayOf(next, v, y)
            }
        }
    }
    val ans = dis[n - 1].min()
    return if (ans == Int.MAX_VALUE) -1 else ans
}