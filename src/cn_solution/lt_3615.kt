package cn_solution

fun maxLen(n: Int, edges: Array<IntArray>, label: String): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val dp = Array(n) { Array(n) { HashMap<Int, Int>() } }
    fun dfs(x: Int, y: Int, used: Int): Int {
        return dp[minOf(x, y)][maxOf(x, y)].computeIfAbsent(used) {
            var res = 0
            for (u in g[x]) {
                val a = 1 shl u
                if (a and used != 0)
                    continue
                for (v in g[y]) {
                    val b = 1 shl v
                    if (b and used != 0 || u == v || label[u] != label[v])
                        continue
                    res = maxOf(res, 2 + dfs(u, v, used or a or b))
                }
            }
            res
        }
    }

    var ans = 0
    for (i in 0 until n) {
        val a = 1 shl i
        ans = maxOf(ans, 1 + dfs(i, i, a))
        for (j in g[i])
            if (label[i] == label[j]) {
                val b = 1 shl j
                ans = maxOf(ans, 2 + dfs(i, j, a or b))
            }
    }
    return ans
}