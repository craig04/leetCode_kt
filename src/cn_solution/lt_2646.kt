package cn_solution

fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val cnt = IntArray(n)
    trips.forEach { (b, e) ->
        fun dfs(u: Int, p: Int): Boolean {
            if (u == e)
                return true
            val res = adj[u].any { it != p && dfs(it, u) }
            if (res)
                cnt[u]++
            return res
        }
        dfs(b, -1)
        cnt[e]++
    }
    val dp = IntArray(n shl 1) { -1 }
    fun search(u: Int, flag: Int, p: Int): Int {
        val idx = u shl 1 or flag
        if (dp[idx] != -1)
            return dp[idx]
        var save = adj[u].sumOf { if (it == p) 0 else search(it, 1, u) }
        if (flag == 1) {
            save = maxOf(save, price[u] / 2 * cnt[u] + adj[u].sumOf {
                if (it == p) 0 else search(it, 0, u)
            })
        }
        dp[idx] = save
        return save
    }
    return cnt.indices.sumOf { cnt[it] * price[it] } - search(0, 1, -1)
}