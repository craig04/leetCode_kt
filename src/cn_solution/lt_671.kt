package cn_solution

import base.TreeNode

fun findSecondMinimumValue(root: TreeNode?): Int {
    val min = root?.`val` ?: return -1
    var ans = -1
    fun TreeNode?.dfs() {
        this ?: return
        if (ans != -1 && `val` > ans)
            return
        if (`val` != min)
            ans = `val`
        left?.dfs()
        right?.dfs()
    }
    root.dfs()
    return ans
}