package cn_solution

fun minCost(n: Int, prices: IntArray, roads: Array<IntArray>): IntArray {
    val max = prices.max()
    val g1 = Array(n) { ArrayList<IntArray>() }
    val g2 = Array(n) { ArrayList<IntArray>() }
    for ((u, v, cost, tax) in roads) {
        if (cost <= max) {
            g1[u].add(intArrayOf(v, cost))
            g1[v].add(intArrayOf(u, cost))
        }
        if (cost * 1L * tax <= max) {
            g2[u].add(intArrayOf(v, cost * tax))
            g2[v].add(intArrayOf(u, cost * tax))
        }
    }
    val dis1 = IntArray(n)
    val dis2 = IntArray(n)
    val q = java.util.PriorityQueue<IntArray> { a, b -> a[1] - b[1] }
    fun dijkstra(g: Array<ArrayList<IntArray>>, u: Int, dis: IntArray) {
        dis.fill(prices[u])
        dis[u] = 0
        q.offer(intArrayOf(u, 0))
        while (q.isNotEmpty()) {
            val (u, d) = q.poll()
            if (dis[u] < d)
                continue
            for ((v, c) in g[u]) {
                if (d + c < dis[v]) {
                    dis[v] = d + c
                    q.offer(intArrayOf(v, d + c))
                }
            }
        }
    }
    return IntArray(n) { i ->
        dijkstra(g1, i, dis1)
        dijkstra(g2, i, dis2)
        var res = prices[i]
        for (j in 0 until n)
            if (i != j && res - prices[j] > dis1[j] + dis2[j])
                res = prices[j] + dis1[j] + dis2[j]
        res
    }
}