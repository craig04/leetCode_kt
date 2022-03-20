package cn_solution

import base.TreeNode

fun isValidBST(root: TreeNode?): Boolean {
    var last = Long.MIN_VALUE
    fun TreeNode?.isBST(): Boolean {
        this ?: return true
        if (!left.isBST() || last >= `val`) return false
        last = `val`.toLong()
        return right.isBST()
    }
    return root.isBST()
}