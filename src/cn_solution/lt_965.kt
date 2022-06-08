package cn_solution

import base.TreeNode

fun isUnivalTree(root: TreeNode?): Boolean {
    val v: Int = root?.`val` ?: return true
    fun TreeNode.dfs(): Boolean {
        return v == `val` && left?.dfs() != false && right?.dfs() != false
    }
    return root.dfs()
}