package cn_solution

fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val n = graph.size
    val out = IntArray(n) { graph[it].size }
    val pre = Array(n) { ArrayList<Int>() }
    for (i in graph.indices)
        for (j in graph[i])
            pre[j].add(i)
    val q = out.indices.filterTo(ArrayDeque()) { out[it] == 0 }
    val ans = ArrayList<Int>()
    while (q.isNotEmpty()) {
        val v = q.removeFirst()
        ans.add(v)
        for (u in pre[v])
            if (--out[u] == 0)
                q.addLast(u)
    }
    ans.sort()
    return ans
}