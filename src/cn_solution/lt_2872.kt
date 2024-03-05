package cn_solution

fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    val adj = Array(n) { mutableListOf<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    val cnt = IntArray(n)
    val mod = IntArray(n) { values[it] % k }
    fun dfs(u: Int, p: Int) {
        for (v in adj[u])
            if (v != p) {
                dfs(v, u)
                cnt[u] += cnt[v]
                mod[u] = (mod[u] + mod[v]) % k
            }
        if (mod[u] == 0)
            cnt[u]++
    }
    dfs(0, -1)
    return cnt[0]
}