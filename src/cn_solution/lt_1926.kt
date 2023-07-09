package cn_solution

fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    val n = maze.size - 1
    val m = maze[0].size - 1
    val rows = maze.indices
    val cols = maze[0].indices
    val q = ArrayDeque<Int>()
    val delta = intArrayOf(0, 1, 0, -1, 1, 0, -1, 0)
    var step = 0
    val entry = entrance[0].shl(16) + entrance[1]
    val visit = hashSetOf(entry)
    q.addLast(entry)
    while (q.isNotEmpty()) {
        step++
        repeat(q.size) {
            val t = q.removeFirst()
            val x = t shr 16
            val y = t and 0xffff
            for (i in delta.indices step 2) {
                val u = x + delta[i]
                val v = y + delta[i + 1]
                if (u !in rows || v !in cols || maze[u][v] == '+')
                    continue
                val next = u.shl(16) + v
                if (visit.add(next)) {
                    if (u == 0 || v == 0 || u == n || v == m)
                        return step
                    q.addLast(next)
                }
            }
        }
    }
    return -1
}