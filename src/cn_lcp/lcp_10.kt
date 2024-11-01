package cn_lcp

import base.TreeNode

fun minimalExecTime(root: TreeNode?): Double {
    fun TreeNode?.dfs(): DoubleArray {
        val ans = DoubleArray(2)
        this ?: return ans
        val l = left.dfs()
        val r = right.dfs()
        ans[0] = l[0] + r[0] + `val`
        ans[1] = maxOf((l[0] + r[0]) * 0.5, l[1], r[1]) + `val`
        return ans
    }
    return root.dfs()[1]
}