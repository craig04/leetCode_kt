package cn_solution

import java.util.*

private fun shortestDistanceAfterQueries_unionFind(n: Int, queries: Array<IntArray>): IntArray {
    val p = IntArray(n - 1) { it }
    var cnt = n - 1
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    return IntArray(queries.size) {
        val (u, v) = queries[it]
        var w = find(u)
        while (w < v - 1) {
            p[w] = v - 1
            cnt--
            w = find(w + 1)
        }
        cnt
    }
}

private fun shortestDistanceAfterQueries_orderedSet(n: Int, queries: Array<IntArray>): IntArray {
    val set = (0 until n).toCollection(TreeSet())
    return IntArray(queries.size) {
        val (u, v) = queries[it]
        while (true) {
            val w = set.higher(u) ?: Int.MAX_VALUE
            if (w >= v)
                break
            set.remove(w)
        }
        set.size - 1
    }
}