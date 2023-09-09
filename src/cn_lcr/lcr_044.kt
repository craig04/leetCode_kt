package cn_lcr

import base.TreeNode

fun largestValues(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    root ?: return result
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    while (q.isNotEmpty()) {
        var element = Int.MIN_VALUE
        repeat(q.size) {
            val node = q.removeFirst()
            element = maxOf(element, node.`val`)
            node.left?.let { q.addLast(it) }
            node.right?.let { q.addLast(it) }
        }
        result.add(element)
    }
    return result
}