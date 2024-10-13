package cn_solution

import base.TreeNode

fun kthLargestPerfectSubtree(root: TreeNode?, k: Int): Int {
    val cnt = IntArray(12)
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        val l = left.dfs()
        val r = right.dfs()
        if (l != r || l == -1)
            return -1
        cnt[l + 1]++
        return l + 1
    }
    root.dfs()
    var t = k
    for (i in cnt.indices.reversed()) {
        if (cnt[i] >= t)
            return 1.shl(i) - 1
        t -= cnt[i]
    }
    return -1
}