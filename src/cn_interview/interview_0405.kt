package cn_interview

import base.TreeNode

fun isValidBST(root: TreeNode?): Boolean {
    var last = Long.MIN_VALUE
    fun TreeNode?.judge(): Boolean {
        this ?: return true
        if (!left.judge() || `val` <= last)
            return false
        last = `val`.toLong()
        return right.judge()
    }
    return root.judge()
}