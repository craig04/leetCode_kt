package cn_solution

fun palindromePath(n: Int, edges: Array<IntArray>, s: String, queries: Array<String>): List<Boolean> {
    val ca = s.toCharArray()
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val path = IntArray(n)
    var ts = 0
    val tin = IntArray(n)
    val tout = IntArray(n)
    val m = 33 - (n - 2).countLeadingZeroBits()
    val fa = Array(n) { IntArray(m) { -1 } }
    val depth = IntArray(n)
    fun dfs(u: Int, p: Int, pre: Int) {
        fa[u][0] = p
        tin[u] = ++ts
        val cur = 1.shl(ca[u] - 'a') xor pre
        path[u] = cur
        for (v in g[u])
            if (v != p) {
                depth[v] = depth[u] + 1
                dfs(v, u, cur)
            }
        tout[u] = ts
    }
    dfs(0, -1, 0)
    for (t in 1 until m) {
        for (i in 0 until n) {
            val j = fa[i][t - 1]
            if (j != -1)
                fa[i][t] = fa[j][t - 1]
        }
    }
    fun lca(u: Int, v: Int): Int {
        var x = u
        var y = v
        if (depth[x] < depth[y]) {
            val z = x
            x = y
            y = z
        }
        var diff = depth[x] - depth[y]
        while (diff != 0) {
            x = fa[x][diff.countTrailingZeroBits()]
            diff = diff and (diff - 1)
        }
        if (x == y)
            return x
        for (i in m - 1 downTo 0) {
            if (fa[x][i] != fa[y][i]) {
                x = fa[x][i]
                y = fa[y][i]
            }
        }
        return fa[x][0]
    }

    val a = IntArray(n + 1)
    fun modify(x: Int, v: Int) {
        var t = x
        while (t <= n) {
            a[t] = a[t] xor v
            t += t and -t
        }
    }

    fun query(x: Int): Int {
        var res = 0
        var t = x
        while (t > 0) {
            res = res xor a[t]
            t = t and (t - 1)
        }
        return res
    }

    val ans = ArrayList<Boolean>()
    for (query in queries) {
        val q = query.split(' ')
        if (q[0][0] == 'q') {
            val u = q[1].toInt()
            val v = q[2].toInt()
            val w = lca(u, v)
            var bits = path[u] xor path[v] xor query(tin[u]) xor query(tin[v])
            bits = 1.shl(ca[w] - 'a') xor bits
            ans.add(bits.countOneBits() <= 1)
        } else {
            val u = q[1].toInt()
            val old = 1.shl(ca[u] - 'a')
            val new = 1.shl(q[2][0] - 'a')
            ca[u] = q[2][0]
            val v = old xor new
            modify(tin[u], v)
            if (tout[u] != n)
                modify(tout[u] + 1, v)
        }
    }
    return ans
}