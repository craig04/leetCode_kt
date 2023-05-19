package cn_solution

import base.TreeNode

fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
    fun TreeNode?.dfs(ancestor: Int): Boolean? = this?.let {
        val cur = ancestor + `val`
        val l = left.dfs(cur)
        val r = right.dfs(cur)
        if (l == null && r == null) {
            return cur >= limit
        }
        if (l == false) left = null
        if (r == false) right = null
        return l == true || r == true
    }
    return if (root.dfs(0) == true) root else null
}