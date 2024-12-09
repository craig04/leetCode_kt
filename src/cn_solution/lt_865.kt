package cn_solution

import base.TreeNode

fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
    val empty = Pair<TreeNode?, Int>(null, 0)
    fun TreeNode?.dfs(): Pair<TreeNode?, Int> {
        this ?: return empty
        val l = left.dfs()
        val r = right.dfs()
        return when {
            l.second > r.second -> Pair(l.first, l.second + 1)
            l.second < r.second -> Pair(r.first, r.second + 1)
            else -> Pair(this, l.second + 1)
        }
    }
    return root.dfs().first
}