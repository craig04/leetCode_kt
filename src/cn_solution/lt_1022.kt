package cn_solution

import base.TreeNode

fun sumRootToLeaf(root: TreeNode?): Int {
    var ans = 0
    fun TreeNode.dfs(pre: Int) {
        val cur = pre * 2 + `val`
        if (left == null && right == null) {
            ans += cur
            return
        }
        left?.dfs(cur)
        right?.dfs(cur)
    }
    root?.dfs(0)
    return ans
}