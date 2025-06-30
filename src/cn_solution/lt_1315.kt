package cn_solution

import base.TreeNode

fun sumEvenGrandparent(root: TreeNode?): Int {
    var ans = 0
    fun TreeNode?.dfs(x: Int, y: Int) {
        this ?: return
        if (y % 2 == 0)
            ans += `val`
        left.dfs(`val`, x)
        right.dfs(`val`, x)
    }
    root?.dfs(1, 1)
    return ans
}