package cn_solution

fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
    val g = HashMap<Int, ArrayList<Int>>()
    val d = HashMap<Int, Int>()
    for ((u, v) in pairs) {
        g.computeIfAbsent(u) { ArrayList() }.add(v)
        d.merge(u, 1, Int::plus)
        d.merge(v, -1, Int::plus)
    }
    val s = d.entries.firstOrNull { it.value == 1 }?.key ?: pairs[0][0]
    val ans = Array(pairs.size) { IntArray(2) }
    var pos = ans.lastIndex
    fun dfs(u: Int) {
        val adj = g[u] ?: return
        while (adj.isNotEmpty()) {
            val v = adj.removeLast()
            dfs(v)
            ans[pos][0] = u
            ans[pos][1] = v
            pos--
        }
    }
    dfs(s)
    return ans
}