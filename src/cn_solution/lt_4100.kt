package cn_solution

fun minActivationCost(edges: Array<IntArray>, values: IntArray): Int {
    val n = values.size
    val g = Array(n) { ArrayList<Int>() }
    var ans = Int.MAX_VALUE
    for ((u, v, c) in edges) {
        val p = values[u].countOneBits() and 1
        val q = values[v].countOneBits() and 1
        when (p) {
            q -> ans = minOf(ans, c)
            0 -> g[u] += c
            else -> g[v] += c
        }
    }
    for (adj in g) {
        if (adj.size < 2)
            continue
        var min = Int.MAX_VALUE / 2
        for (c in adj) {
            ans = minOf(ans, min + c)
            min = minOf(min, c)
        }
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}