package cn_solution

import base.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        return when (left) {
            null -> right == null
            else -> right != null && left.`val` == right.`val` && isSymmetric(
                left.left,
                right.right
            ) && isSymmetric(left.right, right.left)
        }
    }
    return root?.run { isSymmetric(left, right) } ?: true
}