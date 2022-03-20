package cn_solution

import base.TreeNode

fun rob(root: TreeNode?): Int {
    val empty = Pair(0, 0)
    fun dfs(root: TreeNode?): Pair<Int, Int> {
        root ?: return empty
        val l = dfs(root.left)
        val r = dfs(root.right)
        return Pair(
            root.`val` + l.second + r.second,
            maxOf(l.first, l.second) + maxOf(r.first, r.second)
        )
    }
    return dfs(root).run { maxOf(first, second) }
}