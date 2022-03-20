package cn_solution

import base.TreeNode

fun sumOfLeftLeaves(root: TreeNode?): Int {
    fun dfs(root: TreeNode?, count: Boolean): Int {
        root ?: return 0
        if (root.left == null && root.right == null) {
            return if (count) root.`val` else 0
        }
        return dfs(root.left, true) + dfs(root.right, false)
    }
    return dfs(root, false)
}