package cn_interview

import base.TreeNode

fun pathSum(root: TreeNode?, sum: Int): Int {
    var result = 0
    fun TreeNode?.dfs(pick: Boolean, ancestor: Int) {
        this ?: return
        val s = ancestor + `val`
        if (s == sum)
            result++
        left.dfs(true, s)
        right.dfs(true, s)
        if (!pick) {
            left.dfs(false, 0)
            right.dfs(false, 0)
        }
    }
    root.dfs(false, 0)
    return result
}