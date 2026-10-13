package cn_solution

fun maxOutput(n: Int, edges: Array<IntArray>, price: IntArray): Long {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u] += v
        g[v] += u
    }
    fun dfs(u: Int, p: Int): LongArray {
        var res = 0L
        var s1 = 0L + price[u]
        var s2 = 0L
        for (v in g[u]) {
            if (v == p)
                continue
            val (sub, c1, c2) = dfs(v, u)
            res = maxOf(res, s1 + c2, s2 + c1, sub)
            s1 = maxOf(s1, price[u] + c1)
            s2 = maxOf(s2, price[u] + c2)
        }
        return longArrayOf(res, s1, s2)
    }
    return dfs(0, -1)[0]
}