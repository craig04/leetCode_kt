package cn_solution

fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
    val n = roads.size + 1
    val adj = Array(n) { ArrayList<Int>() }
    for ((u, v) in roads) {
        adj[u].add(v)
        adj[v].add(u)
    }
    var cost = 0L
    fun dfs(u: Int, p: Int): Int {
        var cur = 1
        for (v in adj[u])
            if (v != p) {
                val sub = dfs(v, u)
                cost += (sub - 1) / seats + 1
                cur += sub
            }
        return cur
    }
    dfs(0, -1)
    return cost
}