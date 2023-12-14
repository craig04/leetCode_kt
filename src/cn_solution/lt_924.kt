package cn_solution

fun minMalwareSpread(graph: Array<IntArray>, initial: IntArray): Int {
    val n = graph.size
    val slice = IntArray(n)
    var index = 0
    fun dfs(u: Int) {
        if (slice[u] != 0)
            return
        slice[u] = index
        for (v in graph[u].indices)
            if (graph[u][v] == 1)
                dfs(v)
    }
    for (i in 0 until n) {
        ++index
        dfs(i)
    }
    val count = IntArray(index + 1)
    slice.forEach { count[it]++ }
    var result = 0
    var reduce = -1
    initial.groupBy { slice[it] }
        .forEach { (idx, list) ->
            val r = if (list.size == 1) count[idx] else 0
            val m = list.min()
            if (r > reduce) {
                reduce = r
                result = m
            } else if (r == reduce && m < result) {
                result = m
            }
        }
    return result
}