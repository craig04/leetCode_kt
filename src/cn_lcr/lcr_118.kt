package cn_lcr

fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val p = IntArray(n + 1) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    return edges.first {
        val a = find(it[0])
        val b = find(it[1])
        if (a != b)
            p[a] = b
        a == b
    }
}