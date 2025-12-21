package cn_solution

fun interactionCosts(n: Int, edges: Array<IntArray>, group: IntArray): Long {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val map = HashMap<Int, Int>()
    for (g in group)
        map.merge(g, 1, Int::plus)
    var ans = 0L
    for ((k, v) in map) {
        fun dfs(u: Int, p: Int): Int {
            var cnt = 0
            if (group[u] == k)
                cnt++
            for (v in g[u])
                if (v != p)
                    cnt += dfs(v, u)
            ans += 1L * cnt * (v - cnt)
            return cnt
        }
        dfs(0, -1)
    }
    return ans
}