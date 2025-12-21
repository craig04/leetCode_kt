package cn_solution

fun maxSubgraphScore(n: Int, edges: Array<IntArray>, good: IntArray): IntArray {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val sub = IntArray(n)
    fun init(u: Int, p: Int): Int {
        sub[u] = if (good[u] == 1) 1 else -1
        for (v in g[u])
            if (v != p)
                sub[u] += maxOf(0, init(v, u))
        return sub[u]
    }
    init(0, -1)
    val ans = IntArray(n)
    ans[0] = sub[0]
    fun dfs(u: Int, p: Int) {
        for (v in g[u])
            if (v != p) {
                val s = ans[u] - maxOf(sub[v], 0)
                ans[v] = sub[v] + maxOf(s, 0)
                dfs(v, u)
            }
    }
    dfs(0, -1)
    return ans
}