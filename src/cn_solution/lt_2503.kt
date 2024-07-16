package cn_solution

import java.util.*

fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
    val row = grid.indices
    val col = grid.first().indices
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val vis = Array(grid.size) { BooleanArray(grid.first().size) }
    val q = PriorityQueue<IntArray> { l, r -> l[0] - r[0] }
    vis[0][0] = true
    q.offer(intArrayOf(grid[0][0], 0, 0))
    val query = Array(queries.size) { intArrayOf(queries[it], it) }
    query.sortBy { it[0] }
    var count = 0
    val ans = IntArray(queries.size)
    for ((bound, idx) in query) {
        while (q.isNotEmpty() && q.peek()[0] < bound) {
            count++
            val (_, i, j) = q.poll()
            for (t in d.indices step 2) {
                val x = i + d[t]
                val y = j + d[t + 1]
                if (x in row && y in col && !vis[x][y]) {
                    vis[x][y] = true
                    q.offer(intArrayOf(grid[x][y], x, y))
                }
            }
        }
        ans[idx] = count
    }
    return ans
}