package cn_solution

import base.ListNode

fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
    val dir = intArrayOf(0, 1, 1, 0, 0, -1, -1, 0)
    var d = 0
    var i = 0
    var j = 0
    val ans = Array(m) { IntArray(n) { -1 } }
    var node = head
    while (node != null) {
        ans[i][j] = node.`val`
        val x = i + dir[d]
        val y = j + dir[d + 1]
        if (x !in 0 until m || y !in 0 until n || ans[x][y] != -1)
            d = (d + 2) % dir.size
        i += dir[d]
        j += dir[d + 1]
        node = node.next
    }
    return ans
}