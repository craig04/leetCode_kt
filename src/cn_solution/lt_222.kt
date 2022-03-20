package cn_solution

import base.TreeNode

fun countNodes(root: TreeNode?): Int {
    root ?: return 0
    fun TreeNode?.height(): Int = if (this == null) 0 else (1 + left.height())
    val left = root.left.height()
    val right = root.right.height()
    return if (left == right) {
        1.shl(left) + countNodes(root.right)
    } else {
        1.shl(right) + countNodes(root.left)
    }
}