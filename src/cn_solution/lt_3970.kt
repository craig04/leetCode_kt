package cn_solution

fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
    val g = Array(n) { ArrayList<IntArray>() }
    for (edge in edges)
        g[edge[0]].add(edge)
    val dis = Array(n) { IntArray(k + 1) { Int.MAX_VALUE } }
    dis[0][1] = 0
    val q = java.util.PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
    q.offer(intArrayOf(0, 0, 1))
    while (q.isNotEmpty()) {
        val (curr, u, cnt) = q.poll()
        if (curr != dis[u][cnt])
            continue
        for ((_, v, w) in g[u]) {
            val next = curr + w
            if (labels[u] != labels[v] && next < dis[v][1]) {
                dis[v][1] = next
                q.offer(intArrayOf(next, v, 1))
            } else if (labels[u] == labels[v] && cnt != k && next < dis[v][cnt + 1]) {
                dis[v][cnt + 1] = next
                q.offer(intArrayOf(next, v, cnt + 1))
            }
        }
    }
    val ans = dis[n - 1].min()
    return if (ans == Int.MAX_VALUE) -1 else ans
}