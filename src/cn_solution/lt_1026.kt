package cn_solution

import base.TreeNode
import kotlin.math.abs

fun maxAncestorDiff(root: TreeNode?): Int {
    fun TreeNode?.search(curMin: Int, curMax: Int): Int = this?.let {
        val min = minOf(curMin, `val`)
        val max = maxOf(curMax, `val`)
        val temp = maxOf(abs(`val` - curMin), abs(`val` - curMax))
        maxOf(temp, left.search(min, max), right.search(min, max))
    } ?: 0
    return root?.run { search(`val`, `val`) } ?: 0
}