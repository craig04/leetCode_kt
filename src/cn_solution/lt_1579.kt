package cn_solution

fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    class UFS {
        val p = IntArray(n + 1) { it }
        var cnt = n
        fun find(x: Int): Int {
            if (p[x] != x)
                p[x] = find(p[x])
            return p[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val u = find(x)
            val v = find(y)
            if (u != v) {
                p[u] = v
                cnt--
            }
            return u != v
        }
    }

    val a = UFS()
    val b = UFS()
    var total = edges.count { (type, u, v) -> type == 3 && a.union(u, v) && b.union(u, v) }
    if (total == n - 1)
        return edges.size - total
    for ((type, u, v) in edges) {
        if (type == 1 && a.union(u, v))
            total++
        else if (type == 2 && b.union(u, v))
            total++
        if (a.cnt == 1 && b.cnt == 1)
            return edges.size - total
    }
    return -1
}