package cn_solution

private fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[i - 1].add(i)
    val dist = IntArray(n)
    val q = IntArray(n)
    var head = 0
    var tail = 0
    return IntArray(queries.size) {
        val query = queries[it]
        g[query[0]].add(query[1])
        dist.fill(Int.MAX_VALUE)
        dist[0] = 0
        q[0] = 0
        head = 0
        tail = 1
        while (head != tail) {
            val u = q[head++]
            for (v in g[u])
                if (dist[v] == Int.MAX_VALUE) {
                    dist[v] = dist[u] + 1
                    q[tail++] = v
                }
        }
        dist[n - 1]
    }
}