package cn_lcp

import base.TreeNode

fun closeLampInTree(root: TreeNode?): Int {
    val method = arrayOf(intArrayOf(0, 3, 5, 6), intArrayOf(1, 2, 4, 7))
    val dp = HashMap<TreeNode, IntArray>()
    fun TreeNode?.dfs(s: Int): Int {
        this ?: return 0
        val a = dp.computeIfAbsent(this) { IntArray(4) { -1 } }
        if (a[s] == -1) {
            a[s] = method[s.countOneBits().and(1).xor(`val`)].minOf {
                val sub = it.xor(s).and(1).or(it.and((2)))
                left.dfs(sub) + right.dfs(sub) + it.countOneBits()
            }
        }
        return a[s]
    }
    return root.dfs(0)
}