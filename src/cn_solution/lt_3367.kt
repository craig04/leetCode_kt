package cn_solution

fun maximizeSumOfWeights(edges: Array<IntArray>, k: Int): Long {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<IntArray>() }
    for ((u, v, w) in edges) {
        g[u].add(intArrayOf(v, w))
        g[v].add(intArrayOf(u, w))
    }
    fun dfs(u: Int, p: Int): LongArray {
        var y = 0L
        val sub = ArrayList<Long>()
        for ((v, w) in g[u]) {
            if (v != p) {
                val s = dfs(v, u)
                y += s[0]
                val diff = w + s[1] - s[0]
                if (diff > 0)
                    sub.add(diff)
            }
        }
        sub.sortDescending()
        for (i in 0 until minOf(k - 1, sub.size))
            y += sub[i]
        var x = y
        if (sub.size >= k)
            x += sub[k - 1]
        return longArrayOf(x, y)
    }
    return dfs(0, -1)[0]
}