package cn_solution

fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
    fun map(x: Int, y: Int) = x.toLong().shl(32) + y
    val set = blocked.mapTo(HashSet()) { map(it[0], it[1]) }
    fun bfs(from: IntArray, to: IntArray): Int {
        val n = 1000000
        val range = 0 until n
        val mask = 0xffffffffL
        val limit = 19900
        val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
        val q = LongArray(limit + 1)
        val vis = HashSet<Long>()
        var tail = 0
        var head = 0
        val fromPos = map(from[0], from[1])
        q[tail++] = fromPos
        vis.add(fromPos)
        val toPos = map(to[0], to[1])
        while (head != tail) {
            val pos = q[head++]
            val u = pos.shr(32).toInt()
            val v = pos.and(mask).toInt()
            for (t in d.indices step 2) {
                val i = u + d[t]
                val j = v + d[t + 1]
                if (i !in range || j !in range)
                    continue
                val adj = map(i, j)
                if (adj == toPos)
                    return 0
                if (adj !in set && vis.add(adj)) {
                    q[tail++] = adj
                    if (tail == limit + 1)
                        return 1
                }
            }
        }
        return 2
    }

    val res = bfs(source, target)
    return res == 0 || (res == 1 && bfs(target, source) == 1)
}