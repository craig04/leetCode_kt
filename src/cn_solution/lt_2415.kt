package cn_solution

import base.TreeNode

fun reverseOddLevels(root: TreeNode?): TreeNode? {
    fun dfs(left: TreeNode?, right: TreeNode?, reverse: Boolean) {
        left ?: return
        right ?: return
        if (reverse) {
            val change = left.`val`
            left.`val` = right.`val`
            right.`val` = change
        }
        dfs(left.left, right.right, !reverse)
        dfs(left.right, right.left, !reverse)
    }
    root?.run { dfs(left, right, true) }
    return root
}