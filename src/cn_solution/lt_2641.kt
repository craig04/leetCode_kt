package cn_solution

import base.TreeNode

fun replaceValueInTree(root: TreeNode?): TreeNode? {
    fun TreeNode.sub() = (left?.`val` ?: 0) + (right?.`val` ?: 0)
    root ?: return null
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    root.`val` = 0
    while (q.isNotEmpty()) {
        val sum = q.sumOf { it.sub() }
        repeat(q.size) {
            val node = q.removeFirst()
            val s = node.sub()
            node.left?.let {
                q.add(it)
                it.`val` = sum - s
            }
            node.right?.let {
                q.add(it)
                it.`val` = sum - s
            }
        }
    }
    return root
}