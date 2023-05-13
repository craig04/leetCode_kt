package cn_solution

import base.TreeNode

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var result = 0
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        val l = left.dfs()
        val r = right.dfs()
        result = maxOf(result, l + r)
        return maxOf(l, r) + 1
    }
    root.dfs()
    return result
}