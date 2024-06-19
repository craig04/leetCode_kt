package cn_solution

fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
    val q = Array(queries.size) { i ->
        queries[i].let { intArrayOf(it[2], it[0], it[1], i) }
    }
    q.sortBy { it[0] }
    edgeList.sortBy { it[2] }
    val ans = BooleanArray(queries.size)
    val p = IntArray(n) { it }
    var i = 0
    fun find(x: Int): Int {
        if (p[x] != x) {
            p[x] = find(p[x])
        }
        return p[x]
    }
    for ((limit, u, v, idx) in q) {
        while (i != edgeList.size && edgeList[i][2] < limit) {
            val x = find(edgeList[i][0])
            val y = find(edgeList[i][1])
            if (x != y)
                p[x] = y
            i++
        }
        ans[idx] = find(u) == find(v)
    }
    return ans
}