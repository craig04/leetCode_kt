package cn_lcr

import base.TreeNode

fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = HashSet<Int>()
    fun dfs(node: TreeNode?): Boolean {
        node ?: return false
        if (k - node.`val` in set) return true
        set.add(node.`val`)
        return dfs(node.left) || dfs(node.right)
    }
    return dfs(root)
}