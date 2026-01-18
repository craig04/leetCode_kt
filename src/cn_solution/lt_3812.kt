package cn_solution

fun minimumFlips(n: Int, edges: Array<IntArray>, start: String, target: String): List<Int> {
    val g = Array(n) { ArrayList<IntArray>() }
    for (i in edges.indices) {
        val (u, v) = edges[i]
        g[u].add(intArrayOf(v, i))
        g[v].add(intArrayOf(u, i))
    }
    val ans = ArrayList<Int>()
    fun dfs(u: Int, p: Int): Boolean {
        var flip = start[u] != target[u]
        for ((v, i) in g[u])
            if (v != p)
                if (dfs(v, u)) {
                    flip = !flip
                    ans.add(i)
                }
        return flip
    }
    if (dfs(0, -1))
        return listOf(-1)
    ans.sort()
    return ans
}