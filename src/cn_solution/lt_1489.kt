package cn_solution

fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
    val p = IntArray(n)
    val indices = Array(edges.size) { it }
    indices.sortBy { edges[it][2] }

    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun kruskal(exclude: Int, include: Int): Int {
        var ans = 0
        var cnt = 0
        for (i in p.indices)
            p[i] = i
        if (include != -1) {
            val (u, v, w) = edges[include]
            p[u] = v
            ans += w
            cnt = 1
        }
        for (i in indices) {
            if (i == exclude)
                continue
            val (u, v, w) = edges[i]
            val x = find(u)
            val y = find(v)
            if (x == y)
                continue
            p[x] = y
            ans += w
            if (++cnt == n - 1)
                return ans

        }
        return -1
    }

    val init = kruskal(-1, -1)
    val yes = edges.indices.filterTo(HashSet()) { kruskal(it, -1) != init }
    val no = edges.indices.filter { it !in yes && kruskal(-1, it) == init }
    return listOf(yes.toList(), no)
}