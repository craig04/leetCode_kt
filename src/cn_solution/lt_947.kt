package cn_solution

fun removeStones(stones: Array<IntArray>): Int {
    val n = stones.size
    val r = IntArray(10001) { -1 }
    val c = IntArray(10001) { -1 }
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun connect(a: IntArray, i: Int, z: Int) {
        if (a[z] == -1)
            a[z] = i
        else
            p[find(a[z])] = i
    }
    for (i in stones.indices) {
        val (x, y) = stones[i]
        connect(r, i, y)
        connect(c, i, x)
    }
    return p.indices.count { it != find(it) }
}