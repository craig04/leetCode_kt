package cn_solution

fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val d = IntArray(n)
    var w = -1
    for ((_, v) in edges)
        if (++d[v - 1] == 2)
            w = v
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    if (w == -1) {
        for (edge in edges) {
            val x = find(edge[0] - 1)
            val y = find(edge[1] - 1)
            if (x == y)
                return edge
            p[x] = y
        }
    }
    val e = ArrayList<IntArray>()
    for (edge in edges) {
        val u = edge[0]
        val v = edge[1]
        if (v != w)
            p[find(u - 1)] = p[find(v - 1)]
        else
            e.add(edge)
    }
    val (u, v) = e[0]
    return if (find(u - 1) != find(v - 1)) e[1] else e[0]
}