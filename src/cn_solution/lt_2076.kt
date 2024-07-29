package cn_solution

fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {
    val forbid = Array(n) { HashSet<Int>() }
    fun ban(x: Int, y: Int) {
        forbid[x].add(y)
        forbid[y].add(x)
    }
    restrictions.forEach { (u, v) -> ban(u, v) }
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    return BooleanArray(requests.size) { i ->
        val (u, v) = requests[i]
        val x = find(u)
        val y = find(v)
        if (x == y)
            return@BooleanArray true
        if (x in forbid[y])
            return@BooleanArray false
        p[x] = y
        for (t in forbid[x])
            ban(t, y)
        true
    }
}