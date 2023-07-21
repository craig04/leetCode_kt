package cn_solution

import base.TreeNode

fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    val dummy = Pair(0, null)
    fun TreeNode?.dfs(): Pair<Int, TreeNode?> = this?.let {
        val l = left.dfs()
        val r = right.dfs()
        when {
            l.first < r.first -> Pair(r.first + 1, r.second)
            l.first > r.first -> Pair(l.first + 1, l.second)
            else -> Pair(l.first + 1, this)
        }
    } ?: dummy
    return root.dfs().second
}