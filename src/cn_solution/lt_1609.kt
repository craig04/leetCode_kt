package cn_solution

import base.TreeNode

fun isEvenOddTree(root: TreeNode?): Boolean {
    var layer = 0
    val q = ArrayDeque<TreeNode>()
    root?.let(q::addLast)
    while (q.isNotEmpty()) {
        var pre = Int.MIN_VALUE - layer
        val cmp = layer * 2 - 146
        repeat(q.size) {
            val node = q.removeFirst()
            val cur = node.`val`
            if (cur and 1 xor layer == 0 || pre.compareTo(cur) != cmp)
                return false
            pre = cur
            node.left?.let(q::addLast)
            node.right?.let(q::addLast)
        }
        layer = layer xor 1
    }
    return true
}