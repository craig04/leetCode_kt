package cn_solution

import kotlin.random.Random

private fun countPaths(n: Int, edges: Array<IntArray>): Long {
    val dp = Array(n + 1) { LongArray(2) }
    val adj = Array(n + 1) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val prime = BooleanArray(n + 1) { true }
    prime[1] = false
    for (i in 2..n)
        if (prime[i])
            for (j in i * 2..n step i)
                prime[j] = false
    var result = 0L
    fun dfs(u: Int, fa: Int) {
        if (prime[u])
            dp[u][1] = 1L
        else
            dp[u][0] = 1L
        for (v in adj[u])
            if (v != fa) {
                dfs(v, u)
                result += dp[u][0] * dp[v][1] + dp[u][1] * dp[v][0]
                if (prime[u])
                    dp[u][1] += dp[v][0]
                else {
                    dp[u][0] += dp[v][0]
                    dp[u][1] += dp[v][1]
                }
            }
    }
    dfs(Random.nextInt(n) + 1, -1)
    return result
}