package cn_solution

private fun minCost(n: Int, edges: Array<IntArray>): Int {
    val g = Array(n) { ArrayList<IntArray>() }
    for ((u, v, w) in edges) {
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, 2 * w))
    }
    val dis = IntArray(n) { Int.MAX_VALUE }
    val q = java.util.PriorityQueue<IntArray> { a, b -> a[1] - b[1] }
    dis[0] = 0
    q.offer(intArrayOf(0, 0))
    while (q.isNotEmpty()) {
        val (u, curr) = q.poll()
        if (u == n - 1)
            break
        if (dis[u] != curr)
            continue
        for ((v, w) in g[u]) {
            val next = curr + w
            if (next < dis[v]) {
                dis[v] = next
                q.offer(intArrayOf(v, next))
            }
        }
    }
    return if (dis[n - 1] == Int.MAX_VALUE) -1 else dis[n - 1]
}