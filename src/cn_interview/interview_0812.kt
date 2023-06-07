package cn_interview

import kotlin.math.abs

fun solveNQueens(n: Int): List<List<String>> {
    val result = ArrayList<List<String>>()
    val cols = IntArray(n)
    val cs = CharArray(n) { '.' }
    fun search(row: Int) {
        if (row == n) {
            val lines = ArrayList<String>()
            for (r in 0 until n) {
                cs[cols[r]] = 'Q'
                lines.add(String(cs))
                cs[cols[r]] = '.'
            }
            result.add(lines)
            return
        }
        for (col in 0 until n) {
            if ((0 until row).any { cols[it] == col || abs(cols[it] - col) == abs(it - row) })
                continue
            cols[row] = col
            search(row + 1)
        }
    }
    search(0)
    return result
}