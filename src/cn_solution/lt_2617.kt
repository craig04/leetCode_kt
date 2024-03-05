package cn_solution

import java.util.*
import kotlin.math.sign

fun minimumVisitedCells(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val step = Array(n) { IntArray(m) }
    val row = Array(n) { PriorityQueue<Int> { a, b -> step[it][a] - step[it][b] } }
    val col = Array(m) { PriorityQueue<Int> { a, b -> step[a][it] - step[b][it] } }
    row[0].add(0)
    col[0].add(0)
    step[0][0] = 1
    for (i in 0 until n) {
        for (j in 1 - i.sign until m) {
            var s = Int.MAX_VALUE
            while (row[i].isNotEmpty()) {
                val y = row[i].peek()
                if (grid[i][y] + y >= j) {
                    s = minOf(s, step[i][y] + 1)
                    break
                }
                row[i].poll()
            }
            while (col[j].isNotEmpty()) {
                val x = col[j].first()
                if (grid[x][j] + x >= i) {
                    s = minOf(s, step[x][j] + 1)
                    break
                }
                col[j].poll()
            }
            if (s != Int.MAX_VALUE) {
                step[i][j] = s
                row[i].add(j)
                col[j].add(i)
            } else {
                step[i][j] = -1
            }
        }
    }
    return step[n - 1][m - 1]
}