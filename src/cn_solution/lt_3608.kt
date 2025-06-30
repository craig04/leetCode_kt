package cn_solution

fun minTime(n: Int, edges: Array<IntArray>, k: Int): Int {
    edges.sortByDescending { it[2] }
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (x != p[x]) p[x] = find(p[x])
        return p[x]
    }

    var cnt = n
    var i = 0
    while (cnt >= k && i < edges.size) {
        val (x, y, _) = edges[i]
        val u = find(x)
        val v = find(y)
        if (u != v) {
            if (cnt-- == k)
                break
            p[u] = v
        }
        i++
    }
    return if (i == edges.size) 0 else edges[i][2]
}