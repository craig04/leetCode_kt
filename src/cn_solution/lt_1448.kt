package cn_solution

import base.TreeNode

fun goodNodes(root: TreeNode?): Int {
    var count = 0
    fun TreeNode?.dfs(largest: Int) {
        this ?: return
        if (largest <= `val`)
            count++
        val next = maxOf(largest, `val`)
        left.dfs(next)
        right.dfs(next)
    }
    root.dfs(Int.MIN_VALUE)
    return count
}