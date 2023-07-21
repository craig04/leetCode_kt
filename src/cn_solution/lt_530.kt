package cn_solution

import base.TreeNode

fun getMinimumDifference(root: TreeNode?): Int {
    var last = -100000
    var result = Int.MAX_VALUE
    fun TreeNode?.dfs() {
        this ?: return
        left?.dfs()
        result = minOf(result, `val` - last)
        last = `val`
        right?.dfs()
    }
    root.dfs()
    return result
}