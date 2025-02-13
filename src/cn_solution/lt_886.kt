package cn_solution

fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in dislikes) {
        g[u - 1].add(v - 1)
        g[v - 1].add(u - 1)
    }
    val c = IntArray(n)
    fun dfs(x: Int, u: Int): Boolean {
        c[x] = u
        return g[x].all { c[it] == -u || c[it] == 0 && dfs(it, -u) }
    }
    return (0 until n).all { c[it] != 0 || dfs(it, 1) }
}