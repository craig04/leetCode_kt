package cn_solution

import base.TreeNode

fun longestZigZag(root: TreeNode?): Int {
    val mask = 0xffffffffL
    var result = 0L
    fun TreeNode?.dfs(): Long {
        this ?: return 0
        val l = 1 + left.dfs().and(mask)
        val r = 1 + right.dfs().shr(32)
        result = maxOf(result, l, r)
        return l shl 32 or r
    }
    root.dfs()
    return result.toInt() - 1
}