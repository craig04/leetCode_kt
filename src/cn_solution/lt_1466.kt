package cn_solution

import kotlin.math.abs

fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val adj = Array(n) { ArrayList<Int>() }
    connections.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(-u)
    }
    var change = 0
    fun dfs(u: Int, from: Int) {
        for (v in adj[u]) {
            val w = abs(v)
            if (w == from)
                continue
            if (v > 0)
                change++
            dfs(w, u)
        }
    }
    dfs(0, -1)
    return change
}