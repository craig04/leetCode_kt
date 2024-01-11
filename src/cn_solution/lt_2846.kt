package cn_solution

import kotlin.random.Random

fun minOperationsQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    fun HashMap<Int, Int>.decrease(w: Int) {
        val value = get(w) ?: 0
        if (value == 1) remove(w) else put(w, value - 1)
    }

    val root = Random.nextInt(n)
    val freq = Array(n) { HashMap<Int, Int>() }
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v, w) ->
        adj[u].add(v)
        adj[u].add(w)
        adj[v].add(u)
        adj[v].add(w)
    }
    fun dfs(f: HashMap<Int, Int>, u: Int, p: Int) {
        freq[u] = HashMap(f)
        for (i in adj[u].indices step 2) {
            val v = adj[u][i]
            val w = adj[u][i + 1]
            if (v == p)
                continue
            f[w] = (f[w] ?: 0) + 1
            dfs(f, v, u)
            f.decrease(w)
        }
    }
    dfs(HashMap(), root, -1)

    val qad = Array(n) { ArrayList<Int>() }
    queries.forEachIndexed { i, (u, v) ->
        qad[u].add(v)
        qad[u].add(i)
        qad[v].add(u)
        qad[v].add(i)
    }
    val f = IntArray(n) { it }
    val vis = BooleanArray(n)
    val ancestor = IntArray(queries.size)
    fun find(u: Int): Int {
        if (f[u] != u)
            f[u] = find(f[u])
        return f[u]
    }

    fun tarjan(u: Int, p: Int) {
        for (i in adj[u].indices step 2) {
            val v = adj[u][i]
            if (v != p) {
                tarjan(v, u)
            }
        }
        vis[u] = true
        for (i in qad[u].indices step 2) {
            val v = qad[u][i]
            if (vis[v])
                ancestor[qad[u][i + 1]] = find(v)
        }
        f[u] = p
    }
    tarjan(root, root)

    return IntArray(queries.size) {
        val (u, v) = queries[it]
        val map = HashMap(freq[u])
        freq[v].forEach { (w, c) -> map[w] = (map[w] ?: 0) + c }
        val a = ancestor[it]
        freq[a].forEach { (w, c) -> map[w] = (map[w] ?: 0) - 2 * c }
        var sum = 0
        var most = 0
        map.values.forEach { c ->
            sum += c
            most = maxOf(most, c)
        }
        sum - most
    }
}