package cn_solution

import java.util.PriorityQueue

private fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v, w) in edges) {
        g[u].add(v)
        g[u].add(w)
        g[v].add(u)
        g[v].add(w)
    }
    val ans = IntArray(n) { -1 }
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    q.add(Pair(0, 0))
    ans[0] = 0
    while (q.isNotEmpty()) {
        val (cur, u) = q.poll()
        if (cur > ans[u])
            continue
        for (i in g[u].indices step 2) {
            val v = g[u][i]
            val w = g[u][i + 1]
            val next = cur + w
            if (next < disappear[v] && (ans[v] == -1 || next < ans[v])) {
                ans[v] = next
                q.offer(Pair(next, v))
            }
        }
    }
    return ans
}