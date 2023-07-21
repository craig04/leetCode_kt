package cn_solution

fun countPairs(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {
    val deg = IntArray(n)
    val cnt = HashMap<Int, Int>()
    edges.forEach {
        val x = it[0] - 1
        val y = it[1] - 1
        deg[x]++
        deg[y]++
        val hash = minOf(x, y) * n + maxOf(x, y)
        cnt[hash] = (cnt[hash] ?: 0) + 1
    }
    val sorted = deg.sortedArrayDescending()
    return IntArray(queries.size) {
        val q = queries[it]
        var raw = 0
        var r = sorted.lastIndex
        for (l in sorted.indices) {
            while (r > l && sorted[l] + sorted[r] <= q)
                r--
            if (r == l)
                break
            raw += r - l
        }
        raw - cnt.count { (hash, freq) ->
            val x = hash / n
            val y = hash % n
            deg[x] + deg[y] > q && deg[x] + deg[y] - freq <= q
        }
    }
}