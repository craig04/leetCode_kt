package cn_offer

import base.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    fun test(left: TreeNode?, right: TreeNode?): Boolean {
        left ?: return right == null
        return right != null && left.`val` == right.`val`
                && test(left.left, right.right)
                && test(left.right, right.left)
    }
    return root?.run { test(left, right) } != false
}