package cn_solution

fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): List<Boolean> {
    val p = IntArray(n + 1) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (i in threshold + 1..n) {
        val x = find(i)
        for (j in i + i..n step i) {
            p[find(j)] = x
        }
    }
    return queries.map { (x, y) -> find(x) == find(y) }
}