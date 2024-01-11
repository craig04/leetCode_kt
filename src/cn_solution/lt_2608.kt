package cn_solution

fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val q = ArrayDeque<Int>()
    val step = IntArray(n)
    val from = IntArray(n)
    val result = (0 until n).minOf { u ->
        q.clear()
        q.add(u)
        step.fill(-1)
        step[u] = 0
        from.fill(-1)
        var ans = Int.MAX_VALUE
        while (q.isNotEmpty() && ans == Int.MAX_VALUE) {
            repeat(q.size) {
                val v = q.removeFirst()
                for (w in adj[v]) {
                    if (step[w] == -1) {
                        step[w] = step[v] + 1
                        from[w] = v
                        q.addLast(w)
                    } else if (from[v] != w) {
                        ans = minOf(ans, step[w] + step[v] + 1)
                    }
                }
            }
        }
        ans
    }
    return if (result == Int.MAX_VALUE) -1 else result
}