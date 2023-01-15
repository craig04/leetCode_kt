package cn_solution

fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    val count = IntArray(n)
    val mark = ByteArray(n * n)
    roads.forEach { (u, v) ->
        count[u]++
        count[v]++
        mark[u * n + v] = 1
        mark[v * n + u] = 1
    }
    var result = 0
    for (i in 0 until n)
        for (j in i + 1 until n)
            result = maxOf(result, count[i] + count[j] - mark[i * n + j])
    return result
}