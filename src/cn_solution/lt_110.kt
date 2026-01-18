package cn_solution

import base.TreeNode
import kotlin.math.abs

fun isBalanced(root: TreeNode?): Boolean {
    fun TreeNode?.height(): Int {
        this ?: return 0
        val l = left.height()
        val r = right.height()
        if (l < 0 || r < 0 || abs(l - r) > 1)
            return -1
        return maxOf(l, r) + 1
    }
    return root.height() >= 0
}