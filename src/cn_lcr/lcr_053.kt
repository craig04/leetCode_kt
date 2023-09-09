package cn_lcr

import base.TreeNode

fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
    var succ: TreeNode? = null
    val target = p?.`val` ?: 0
    fun TreeNode.dfs() {
        if (`val` <= target)
            right?.dfs()
        else {
            succ = this
            left?.dfs()
        }
    }
    root?.dfs()
    return succ
}