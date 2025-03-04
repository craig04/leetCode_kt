package cn_solution

fun placedCoins(edges: Array<IntArray>, cost: IntArray): LongArray {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val ans = LongArray(n)
    fun dfs(u: Int, p: Int): ArrayList<Int> {
        var res = arrayListOf(cost[u])
        for (v in g[u])
            if (v != p)
                res.addAll(dfs(v, u))
        res.sortDescending()
        val m = res.size
        if (m >= 3) {
            ans[u] = maxOf(
                ans[u],
                1L * res[0] * res[1] * res[2],
                1L * res[0] * res[m - 2] * res[m - 1]
            )
        } else {
            ans[u] = 1
        }
        if (m >= 5)
            res = arrayListOf(res[0], res[1], res[2], res[m - 2], res[m - 1])
        return res
    }
    dfs(0, -1)
    return ans
}