package cn_solution

fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
    val q = Array(queries.size) { it }
    q.sortBy { queries[it] }
    items.sortBy { it[0] }
    val ans = IntArray(queries.size)
    var beauty = 0
    var i = 0
    for (j in q.indices) {
        val query = queries[q[j]]
        while (i < items.size && items[i][0] <= query)
            beauty = maxOf(beauty, items[i++][1])
        ans[q[j]] = beauty
    }
    return ans
}