package cn_lcp

fun extractMantra(matrix: Array<String>, mantra: String): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = matrix.size
    val m = matrix[0].length
    val l = mantra.length
    val vis = Array(n) { Array(m) { BooleanArray(l) } }
    vis[0][0][0] = true
    val q = ArrayDeque<IntArray>()
    q.addLast(intArrayOf(0, 0, 0, 0))
    while (q.isNotEmpty()) {
        val (x, y, z, s) = q.removeFirst()
        if (matrix[x][y] == mantra[z]) {
            if (z == l - 1)
                return s + 1
            if (!vis[x][y][z + 1]) {
                vis[x][y][z + 1] = true
                q.addLast(intArrayOf(x, y, z + 1, s + 1))
            }
        } else {
            for (i in d.indices.step(2)) {
                val u = x + d[i]
                val v = y + d[i + 1]
                if (u in 0 until n && v in 0 until m && !vis[u][v][z]) {
                    vis[u][v][z] = true
                    q.addLast(intArrayOf(u, v, z, s + 1))
                }
            }
        }
    }
    return -1
}