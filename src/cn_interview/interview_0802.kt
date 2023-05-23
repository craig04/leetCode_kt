package cn_interview

import java.util.*

fun pathWithObstacles(obstacleGrid: Array<IntArray>): List<List<Int>> {
    val result = LinkedList<List<Int>>()
    val n = obstacleGrid.lastIndex
    val m = obstacleGrid[0].lastIndex
    val rows = 0..n
    val cols = 0..m
    val visit = Array(n + 1) { BooleanArray(m + 1) }
    val step = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    fun dfs(i: Int, j: Int): Boolean {
        if (obstacleGrid[i][j] == 1 || visit[i][j]) {
            return false
        }
        if (i == n && j == m) {
            result.addFirst(listOf(i, j))
            return true
        }
        visit[i][j] = true
        step.forEach { (x, y) ->
            val p = i + x
            val q = j + y
            if (p in rows && q in cols && dfs(p, q)) {
                result.addFirst(listOf(i, j))
                return true
            }
        }
        return false
    }
    dfs(0, 0)
    return result
}