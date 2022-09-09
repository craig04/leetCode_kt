package cn_solution

import base.TreeNode

fun longestUnivaluePath(root: TreeNode?): Int {
    var result = 0
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        var l = left.dfs()
        if (left?.`val` != `val`)
            l = 0
        var r = right.dfs()
        if (right?.`val` != `val`)
            r = 0
        result = maxOf(result, l + r)
        return maxOf(l, r) + 1
    }
    root.dfs()
    return result
}