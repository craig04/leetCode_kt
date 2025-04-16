package cn_solution

fun baseUnitConversions(conversions: Array<IntArray>): IntArray {
    val n = conversions.size + 1
    val ans = IntArray(n)
    ans[0] = 1
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v, w) in conversions) {
        g[u].add(v)
        g[u].add(w)
    }
    val q = ArrayDeque<Int>()
    q.add(0)
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (i in g[u].indices.step(2)) {
            val v = g[u][i]
            val w = g[u][i + 1]
            q.add(v)
            ans[v] = (1L * ans[u] * w).mod(1000000007)
        }
    }
    return ans
}