package cn_solution

import base.TreeNode

fun bstToGst(root: TreeNode?): TreeNode? {
    var sum = 0
    fun TreeNode.dfs() {
        right?.dfs()
        sum += `val`
        `val` = sum
        left?.dfs()
    }
    root?.dfs()
    return root
}