package solution

import base.TreeNode

fun goodNodes(root: TreeNode?): Int {
    return goodNodes(root, Integer.MIN_VALUE)
}

private fun goodNodes(node: TreeNode?, max: Int): Int {
    if (node == null) {
        return 0
    }
    val next = maxOf(max, node.`val`)
    var result = goodNodes(node.left, next) + goodNodes(node.right, next)
    if (node.`val` >= max) {
        ++result
    }
    return result
}