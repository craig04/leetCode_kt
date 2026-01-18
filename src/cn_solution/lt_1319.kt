package cn_solution

fun makeConnected(n: Int, connections: Array<IntArray>): Int {
    if (connections.size < n - 1)
        return -1
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    var cnt = n
    for ((u, v) in connections) {
        val x = find(u)
        val y = find(v)
        if (x != y) {
            p[x] = y
            cnt--
        }
    }
    return cnt - 1
}