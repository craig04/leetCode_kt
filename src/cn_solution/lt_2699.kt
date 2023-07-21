package cn_solution

import kotlin.math.abs

fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
    val adj = Array(n) { IntArray(n) { 0 } }
    val mod = ArrayList<IntArray>()
    edges.forEach {
        val (u, v, w) = it
        adj[u][v] = abs(w)
        adj[v][u] = abs(w)
        if (w == -1)
            mod.add(it)
    }
    val k = mod.size
    val help = target - 1L

    fun construct(index: Long) {
        var temp = index
        mod.forEach {
            val (u, v, _) = it
            val dist = minOf(temp, help).toInt() + 1
            it[2] = dist
            adj[u][v] = dist
            adj[v][u] = dist
            temp -= dist - 1
        }
    }

    fun dijkstra(): Long {
        val chosen = BooleanArray(n)
        val dist = LongArray(n) { Long.MAX_VALUE }
        dist[source] = 0
        repeat(n) {
            var u = -1
            var temp = Long.MAX_VALUE
            for (i in chosen.indices) {
                if (!chosen[i] && dist[i] < temp) {
                    u = i
                    temp = dist[i]
                }
            }
            if (u == destination)
                return dist[destination]
            chosen[u] = true
            adj[u].forEachIndexed { v, d ->
                if (!chosen[v] && d != 0)
                    dist[v] = minOf(dist[v], dist[u] + d)
            }
        }
        return dist[destination]
    }
    if (dijkstra() > target)
        return emptyArray()
    mod.forEach { (u, v, _) ->
        adj[u][v] = target
        adj[v][u] = target
    }
    if (dijkstra() < target)
        return emptyArray()
    var l = 0L
    var r = k * help + 1
    val longTarget = target.toLong()
    while (true) {
        val mid = (l + r) shr 1
        construct(mid)
        val dist = dijkstra()
        if (dist == longTarget)
            break
        if (dist < longTarget)
            l = mid + 1
        else
            r = mid - 1
    }
    return edges
}