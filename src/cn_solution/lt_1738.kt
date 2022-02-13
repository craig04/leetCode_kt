package cn_solution

import java.util.*

fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
    val x = Array(2) { IntArray(matrix[0].size + 1) }
    val q = PriorityQueue<Int>()
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            val cur = i and 1
            val pre = 1 - cur
            val temp = x[cur][j] xor x[pre][j + 1] xor x[pre][j] xor matrix[i][j]
            x[cur][j + 1] = temp
            q.offer(temp)
            if (q.size > k) {
                q.poll()
            }
        }
    }
    return q.peek()
}