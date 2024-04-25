package cn_solution

private fun minMalwareSpread(graph: Array<IntArray>, initial: IntArray): Int {
    val visit = BooleanArray(graph.size)
    val q = ArrayDeque<Int>()
    fun calculate(remove: Int): Int {
        visit.fill(false)
        for (i in initial)
            if (i != remove) {
                visit[i] = true
                q.addLast(i)
            }
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for (v in graph[u].indices)
                if (v != remove && graph[u][v] == 1 && !visit[v]) {
                    visit[v] = true
                    q.addLast(v)
                }
        }
        return visit.count { it }
    }
    initial.sort()
    return initial.minBy { calculate(it) }
}