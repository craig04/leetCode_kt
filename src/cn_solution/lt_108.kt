package cn_solution

import base.TreeNode

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun build(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        val m = (l + r + 1) shr 1
        return TreeNode(nums[m]).apply {
            left = build(l, m - 1)
            right = build(m + 1, r)
        }
    }
    return build(0, nums.lastIndex)
}