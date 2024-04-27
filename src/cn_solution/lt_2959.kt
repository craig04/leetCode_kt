package cn_solution

fun numberOfSets(n: Int, maxDistance: Int, roads: Array<IntArray>): Int {
    val dist = Array(n) { IntArray(n) }
    return (0 until 1.shl(n)).count { mask ->
        val bit = BooleanArray(n) { 1.shl(it).and(mask) != 0 }
        for (i in 0 until n) {
            dist[i].fill(Int.MAX_VALUE shr 1)
            dist[i][i] = 0
        }
        for ((u, v, w) in roads) {
            if (bit[u] || bit[v])
                continue
            dist[u][v] = minOf(dist[u][v], w)
            dist[v][u] = minOf(dist[v][u], w)
        }
        val indices = bit.indices.filter { !bit[it] }
        for (k in indices)
            for (i in indices)
                for (j in indices)
                    dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
        indices.all { i -> indices.all { j -> dist[i][j] <= maxDistance } }
    }
}