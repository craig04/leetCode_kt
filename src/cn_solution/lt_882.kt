package cn_solution

fun reachableNodes(edges: Array<IntArray>, maxMoves: Int, n: Int): Int {
    val g = Array(n) { ArrayList<IntArray>() }
    for ((u, v, cnt) in edges) {
        g[u].add(intArrayOf(v, cnt + 1))
        g[v].add(intArrayOf(u, cnt + 1))
    }
    val dis = IntArray(n) { Int.MAX_VALUE }
    dis[0] = 0
    val q = java.util.PriorityQueue<IntArray> { (a), (b) -> a - b }
    q.offer(intArrayOf(0, 0))
    var ans = 0
    while (q.isNotEmpty()) {
        val (cur, u) = q.poll()
        if (dis[u] != cur)
            continue
        ans++
        for ((v, cnt) in g[u]) {
            val suf = cur + cnt
            if (suf > maxMoves)
                continue
            if (suf < dis[v]) {
                dis[v] = suf
                q.offer(intArrayOf(suf, v))
            }
        }
    }
    return ans + edges.sumOf { (u, v, cnt) ->
        val x = maxOf(0, maxMoves - dis[u])
        val y = maxOf(0, maxMoves - dis[v])
        minOf(cnt, x + y)
    }
}