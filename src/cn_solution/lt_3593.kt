package cn_solution

fun minIncrease(n: Int, edges: Array<IntArray>, cost: IntArray): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    var ans = 1
    fun dfs(u: Int, p: Int): Long {
        var max = 0L
        var cnt = 0
        for (v in g[u])
            if (v != p) {
                val s = dfs(v, u)
                if (max < s) {
                    max = s
                    cnt = 1
                } else if (s == max)
                    cnt++
            }
        ans += g[u].size - 1 - cnt
        return max + cost[u]
    }
    dfs(0, -1)
    return ans
}