package cn_lcr

fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val index = HashMap<String, Int>()
    fun String.index() = index.computeIfAbsent(this) { index.size }
    val adj = HashMap<Int, ArrayList<Pair<Int, Double>>>()
    equations.forEachIndexed { i, (a, b) ->
        val u = a.index()
        val v = b.index()
        adj.computeIfAbsent(u) { ArrayList() }.add(Pair(v, values[i]))
        adj.computeIfAbsent(v) { ArrayList() }.add(Pair(u, 1 / values[i]))
    }
    fun dfs(u: Int, target: Int, visit: BooleanArray): Double? {
        visit[u] = true
        for ((v, value) in adj[u]!!) {
            if (v == target) return value
            if (visit[v]) continue
            dfs(v, target, visit)?.let { return it * value }
        }
        return null
    }
    return DoubleArray(queries.size) {
        val u = index[queries[it][0]]
        val v = index[queries[it][1]]
        if (u == null || v == null)
            return@DoubleArray -1.0
        dfs(u, v, BooleanArray(index.size)) ?: -1.0
    }
}