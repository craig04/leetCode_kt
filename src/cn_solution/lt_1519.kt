package cn_solution

fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val ans = IntArray(n)
    fun dfs(u: Int, p: Int): IntArray {
        val cnt = IntArray(26)
        for (v in g[u])
            if (v != p) {
                val sub = dfs(v, u)
                for (i in 0 until 26)
                    ans[i] += sub[i]
            }
        ans[u] = ++cnt[labels[u] - 'a']
        return cnt
    }
    dfs(0, -1)
    return ans
}