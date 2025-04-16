package cn_solution

fun treeQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val g = Array(n + 1) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val enter = IntArray(n + 1)
    val leave = IntArray(n + 1)
    var clock = 0
    fun dfs(u: Int, p: Int) {
        enter[u] = ++clock
        for (v in g[u])
            if (v != p)
                dfs(v, u)
        leave[u] = clock
    }
    dfs(1, 0)

    val a = IntArray(n + 2)
    val weight = IntArray(n + 1)
    fun add(x: Int, d: Int) {
        var y = x
        while (y <= n) {
            a[y] += d
            y += y and -y
        }
    }

    fun query(x: Int): Int {
        var ans = 0
        var y = x
        while (y > 0) {
            ans += a[y]
            y = y and (y - 1)
        }
        return ans
    }

    fun update(u: Int, v: Int, w: Int) {
        val x = if (enter[u] < enter[v]) v else u
        val e = enter[x]
        val l = leave[x]
        val diff = w - weight[e]
        weight[e] = w
        add(e, diff)
        add(l + 1, -diff)
    }
    for ((u, v, w) in edges)
        update(u, v, w)
    val ans = ArrayList<Int>()
    for (q in queries) {
        when (q[0]) {
            1 -> update(q[1], q[2], q[3])
            2 -> ans.add(query(enter[q[1]]))
        }
    }
    return ans.toIntArray()
}