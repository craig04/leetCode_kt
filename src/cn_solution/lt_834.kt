package cn_solution

fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val ans = IntArray(n)
    val dp = IntArray(n)
    val sz = IntArray(n)
    fun init(u: Int) {
        sz[u] = 1
        for (v in adj[u]) {
            if (sz[v] == 0) {
                init(v)
                sz[u] += sz[v]
                dp[u] += dp[v] + sz[v]
            }
        }
    }

    fun dfs(u: Int) {
        ans[u] = dp[u]
        for (v in adj[u]) {
            if (ans[v] == 0) {
                dp[u] -= dp[v] + sz[v]
                sz[u] -= sz[v]
                sz[v] += sz[u]
                dp[v] += dp[u] + sz[u]
                dfs(v)
                dp[v] -= dp[u] + sz[u]
                sz[v] -= sz[u]
                sz[u] += sz[v]
                dp[u] += dp[v] + sz[v]
            }
        }
    }
    init(0)
    dfs(0)
    return ans
}