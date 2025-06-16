package cn_solution

fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
    val p = IntArray(n)
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    edges.sortWith(compareBy({ -it[3] }, { -it[2] }))
    var l = -1
    var r = 200000
    while (l != r) {
        val m = (l + r + 1) shr 1
        fun check(): Boolean {
            for (i in 0 until n)
                p[i] = i
            var edge = 0
            var upgrade = 0
            for ((u, v, s, must) in edges) {
                val x = find(u)
                val y = find(v)
                when {
                    must == 1 -> {
                        if (s < m || x == y)
                            return false
                        p[x] = y
                        edge++
                    }
                    edge >= n - 1 -> break
                    x != y -> {
                        if (s * 2 < m || s < m && ++upgrade > k)
                            return false
                        p[x] = y
                        edge++
                    }
                }
            }
            return edge == n - 1
        }
        if (check())
            l = m
        else
            r = m - 1
    }
    return l
}