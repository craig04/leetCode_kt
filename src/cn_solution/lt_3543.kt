package cn_solution

fun maxWeight(n: Int, edges: Array<IntArray>, k: Int, t: Int): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v, w) in edges) {
        g[u].add(v)
        g[u].add(w)
    }
    var ans = -1
    val set = HashSet<Int>()
    fun dfs(u: Int, e: Int, s: Int) {
        if (e == k) {
            ans = maxOf(ans, s)
            return
        }
        val key = (s * k + e) * n + u
        if (!set.add(key))
            return
        for (i in 0 until g[u].size step 2) {
            val sum = s + g[u][i + 1]
            if (sum < t)
                dfs(g[u][i], e + 1, sum)
        }
    }
    for (i in 0 until n)
        dfs(i, 0, 0)
    return ans
}