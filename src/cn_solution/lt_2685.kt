package cn_solution

fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((a, b) in edges) {
        g[a].add(b)
        g[b].add(a)
    }
    val vis = BooleanArray(n)
    var v = 0
    var e = 0
    fun dfs(x: Int) {
        vis[x] = true
        v++
        e += g[x].size
        for (y in g[x])
            if (!vis[y])
                dfs(y)
    }

    var ans = 0
    for (x in 0 until n)
        if (!vis[x]) {
            v = 0
            e = 0
            dfs(x)
            if (e == v * (v - 1))
                ans++
        }
    return ans
}