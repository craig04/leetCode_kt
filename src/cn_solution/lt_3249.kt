package cn_solution

fun countGoodNodes(edges: Array<IntArray>): Int {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    var ans = 0
    fun dfs(u: Int, p: Int): Int {
        var cnt = 1
        var sub = 0
        for (v in g[u])
            if (v != p) {
                val s = dfs(v, u)
                cnt += s
                if (sub == 0)
                    sub = s
                else if (sub != s)
                    sub = -1
            }
        if (sub != -1)
            ans++
        return cnt
    }
    dfs(0, -1)
    return ans
}