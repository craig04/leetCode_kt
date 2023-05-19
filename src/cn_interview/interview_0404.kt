package cn_interview

import base.TreeNode
import kotlin.math.abs

fun isBalanced(root: TreeNode?): Boolean {
    fun TreeNode?.height(): Int {
        this ?: return 0
        val l = left.height()
        if (l == -2) {
            return -2
        }
        val r = right.height()
        return if (abs(l - r) > 1) -2 else maxOf(l, r) + 1
    }
    return root.height() != -2
}