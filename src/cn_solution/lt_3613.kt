package cn_solution

fun minCost(n: Int, edges: Array<IntArray>, k: Int): Int {
    if (k == n)
        return 0
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (x != p[x])
            p[x] = find(p[x])
        return p[x]
    }
    edges.sortBy { it[2] }
    var cnt = n
    for ((u, v, w) in edges) {
        val x = find(u)
        val y = find(v)
        if (x != y) {
            p[x] = y
            if (--cnt == k)
                return w
        }
    }
    return -1
}