package base

class UnionFind(size: Int) {

    private val p = IntArray(size) { it }

    fun find(x: Int): Int {
        if (p[x] != x) {
            p[x] = find(p[x])
        }
        return p[x]
    }

    fun union(x: Int, y: Int) {
        val u = find(x)
        val v = find(y)
        if (u != v) {
            p[u] = v
        }
    }
}