package cn_solution

import base.TreeNode
import kotlin.math.abs

private fun isBalanced(root: TreeNode?): Boolean {
    return height(root) != null
}

private fun height(root: TreeNode?): Int? {
    root ?: return 0
    val left = height(root.left) ?: return null
    val right = height(root.right) ?: return null
    return if (abs(left - right) > 1) null else maxOf(left, right) + 1
}