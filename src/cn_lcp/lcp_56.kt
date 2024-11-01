package cn_lcp

fun conveyorBelt(matrix: Array<String>, start: IntArray, end: IntArray): Int {
    val map = "^<>v".run { indices.associateBy { this[it] } }
    val n = matrix.size
    val m = matrix[0].length
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val q = ArrayDeque<Int>()
    val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val (sx, sy) = start
    val (tx, ty) = end
    q.addLast(sx * m + sy)
    dist[sx][sy] = 0
    while (q.isNotEmpty()) {
        var pos = q.removeFirst()
        val x = pos / m
        val y = pos % m
        if (x == tx && y == ty)
            return dist[x][y]
        val direction = map[matrix[x][y]] ?: 0
        for (i in d.indices.step(2)) {
            val u = x + d[i]
            val v = y + d[i + 1]
            if (u !in 0 until n || v !in 0 until m)
                continue
            val free = direction == i / 2
            val t = dist[x][y] + if (free) 0 else 1
            if (dist[u][v] > t) {
                dist[u][v] = t
                pos = u * m + v
                if (free)
                    q.addFirst(pos)
                else
                    q.addLast(pos)
            }
        }
    }
    return 0
}