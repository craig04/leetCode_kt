package cn_solution

private fun minMalwareSpread(graph: Array<IntArray>, initial: IntArray): Int {
    val n = graph.size
    val init = BooleanArray(n)
    initial.forEach { init[it] = true }
    var remove = -1
    val visit = BooleanArray(n)
    var count = 0
    var infect = false
    fun dfs(u: Int) {
        visit[u] = true
        count++
        infect = infect or init[u]
        for (v in 0 until n)
            if (v != remove && !visit[v] && graph[u][v] == 1)
                dfs(v)
    }

    fun traversal(r: Int): Int {
        var infection = 0
        remove = r
        visit.fill(false)
        for (i in 0 until n) {
            if (i != r && !visit[i]) {
                count = 0
                infect = false
                dfs(i)
                if (infect) {
                    infection += count
                }
            }
        }
        return infection
    }
    return (0 until n).asSequence().filter { init[it] }.minBy { traversal(it) }
}