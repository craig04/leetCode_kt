package cn_solution

fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
    val n = quiet.size
    val d = IntArray(n)
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in richer) {
        d[v]++
        g[u].add(v)
    }
    val ans = IntArray(n) { it }
    val q = d.indices.filterTo(ArrayDeque()) { d[it] == 0 }
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (v in g[u]) {
            if (--d[v] == 0)
                q.add(v)
            if (quiet[ans[u]] < quiet[ans[v]])
                ans[v] = ans[u]
        }
    }
    return ans
}