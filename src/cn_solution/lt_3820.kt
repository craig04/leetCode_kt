package cn_solution

fun specialNodes(n: Int, edges: Array<IntArray>, x: Int, y: Int, z: Int): Int {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    fun bfs(root: Int): IntArray {
        val dis = IntArray(n) { -1 }
        dis[root] = 0
        val q = ArrayDeque<Int>()
        q.add(root)
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for (v in g[u])
                if (dis[v] == -1) {
                    dis[v] = dis[u] + 1
                    q.add(v)
                }
        }
        return dis
    }

    fun Int.pow() = 1L * this * this

    val u = bfs(x)
    val v = bfs(y)
    val w = bfs(z)
    return (0 until n).count { i ->
        val l = intArrayOf(u[i], v[i], w[i])
        l.sort()
        val (a, b, c) = l
        a.pow() + b.pow() == c.pow()
    }
}