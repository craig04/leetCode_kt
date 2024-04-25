package cn_solution

import kotlin.math.sign

private fun cherryPickup(grid: Array<IntArray>): Int {
    val m = grid[0].size
    val cols = 0 until m
    var pre = Array(m) { IntArray(m) { -1 } }
    var cur = Array(m) { IntArray(m) { -1 } }
    val dir = intArrayOf(-1, -1, -1, 0, -1, 1, 0, -1, 0, 0, 0, 1, 1, -1, 1, 0, 1, 1)
    pre[0][m - 1] = grid[0][0] + grid[0][m - 1]
    for (i in 1 until grid.size) {
        for (a in cols) {
            for (b in a until m) {
                cur[a][b] = -1
                val score = grid[i][a] + (b - a).sign * grid[i][b]
                for (k in dir.indices step 2) {
                    val x = a + dir[k]
                    val y = b + dir[k + 1]
                    if (x !in cols || y !in cols || x > y || pre[x][y] == -1)
                        continue
                    cur[a][b] = maxOf(cur[a][b], score + pre[x][y])
                }
            }
        }
        val tmp = cur
        cur = pre
        pre = tmp
    }
    return pre.maxOf { it.max() }
}