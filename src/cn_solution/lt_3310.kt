package cn_solution

fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in invocations)
        g[u].add(v)
    val f = BooleanArray(n)
    fun dfs(u: Int) {
        if (f[u])
            return
        f[u] = true
        g[u].forEach(::dfs)
    }
    dfs(k)
    return if (invocations.any { (u, v) -> !f[u] && f[v] })
        (0 until n).toList()
    else
        (0 until n).filter { !f[it] }
}