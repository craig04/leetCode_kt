package cn_lcp

import base.TreeNode

fun maxValue(root: TreeNode?, k: Int): Int {
    val empty = IntArray(k + 1)
    fun TreeNode?.dfs(): IntArray {
        this ?: return empty
        val ans = IntArray(k + 1)
        val l = left.dfs()
        val r = right.dfs()
        ans[0] = l.max() + r.max()
        for (i in 1..k)
            ans[i] = `val` + (0 until i).maxOf { j -> l[j] + r[i - 1 - j] }
        return ans
    }
    return root.dfs().max()
}