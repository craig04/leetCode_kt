package cn_lcr

import base.TreeNode

fun findBottomLeftValue(root: TreeNode?): Int {
    val q = ArrayDeque<TreeNode>()
    q.add(root ?: return 0)
    var result = 0
    while (q.isNotEmpty()) {
        val count = q.size
        result = q.first().`val`
        repeat(count) {
            val node = q.removeFirst()
            node.left?.also { q.add(it) }
            node.right?.also { q.add(it) }
        }
    }
    return result
}