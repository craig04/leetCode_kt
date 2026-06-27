package cn_solution

import base.TreeNode

fun isCompleteTree(root: TreeNode?): Boolean {
    var max = 1
    var cnt = 0
    fun TreeNode?.dfs(idx: Int) {
        this ?: return
        max = maxOf(max, idx)
        cnt++
        left.dfs(idx * 2)
        right.dfs(idx * 2 + 1)
    }
    root.dfs(1)
    return cnt == max
}