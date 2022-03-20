package cn_solution

import base.TreeNode

fun minDepth(root: TreeNode?): Int {
    fun dfs(root: TreeNode?): Int {
        return when {
            root == null -> Int.MAX_VALUE
            root.left == null && root.right == null -> 1
            else -> minOf(dfs(root.left), dfs(root.right)) + 1
        }
    }
    return root?.let { dfs(it) } ?: 0
}