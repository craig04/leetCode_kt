package cn_solution

fun maximumPoints(edges: Array<IntArray>, coins: IntArray, k: Int): Int {
    val n = edges.size + 1
    val adj = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        adj[u].add(v)
        adj[v].add(u)
    }
    val dp = Array(n) { IntArray(15) { -1 } }
    for (i in 0 until n)
        dp[i][14] = 0
    fun dfs(u: Int, half: Int, fa: Int): Int {
        if (dp[u][half] == -1) {
            var profit1 = coins[u].shr(half) - k
            var profit2 = coins[u].shr(half + 1)
            for (v in adj[u])
                if (v != fa) {
                    profit1 += dfs(v, half, u)
                    profit2 += dfs(v, half + 1, u)
                }
            dp[u][half] = maxOf(profit1, profit2)
        }
        return dp[u][half]
    }
    return dfs(0, 0, -1)
}