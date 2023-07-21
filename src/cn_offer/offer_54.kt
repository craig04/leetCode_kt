package cn_offer

import base.TreeNode

fun kthLargest(root: TreeNode?, k: Int): Int {
    var result = 0
    var idx = 0
    fun TreeNode?.dfs() {
        this ?: return
        right.dfs()
        if (++idx == k)
            result = `val`
        if (idx < k)
            left.dfs()
    }
    root.dfs()
    return result
}