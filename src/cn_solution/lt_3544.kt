package cn_solution

fun subtreeInversionSum(edges: Array<IntArray>, nums: IntArray, k: Int): Long {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val dp = LongArray(n * k * 2) { Long.MIN_VALUE }
    fun dfs(u: Int, fa: Int, cd: Int, p: Int): Long {
        val key = (u * k + cd) * 2 + p
        if (dp[key] != Long.MIN_VALUE)
            return dp[key]
        val cur = 0L + if (p == 0) nums[u] else -nums[u]
        var ans = cur
        for (v in g[u])
            if (v != fa)
                ans += dfs(v, u, maxOf(cd - 1, 0), p)
        if (cd == 0) {
            var rev = -cur
            for (v in g[u])
                if (v != fa)
                    rev += dfs(v, u, k - 1, 1 - p)
            ans = maxOf(ans, rev)
        }
        dp[key] = ans
        return ans
    }
    return dfs(0, -1, 0, 0)
}